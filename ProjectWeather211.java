import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Class for retrieving city weather information
public class ProjectWeather211 {

    // Method to fetch city weather data using OpenWeatherMap API
    public static double CityWeather(String cityName, String countryCode) throws Exception {
        double cityTemp = 0.0;
        BufferedReader br = null;

        try {
            // Construct the API URL with city name, country code, and API key
            String apiKey = "33c61ab5246ee1d09c32404ed83bb489";
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "," + countryCode + "&appid=" + apiKey;

            // Open a connection to the API URL
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the API response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Extract temperature from the JSON response
            cityTemp = extractTemperature(response.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (br != null) {
                br.close();
            }
        }

        // Convert temperature from Kelvin to Fahrenheit
        return ((cityTemp - 273.15) * 9) / 5 + 32;
    }

    // Method to extract temperature from JSON response
    private static double extractTemperature(String response) {
        double cityTemp = 0.0;

        try {
            // Find the index of the temperature value in the JSON response
            int tempIndex = response.indexOf("\"temp\":");

            // Check if the temperature value exists in the response
            if (tempIndex != -1) {
                // Find the index of the next comma after the temperature value
                int commaIndex = response.indexOf(",", tempIndex);

                // Extract the temperature substring
                String tempString = response.substring(tempIndex + 7, commaIndex);

                // Parse the temperature value to double
                cityTemp = Double.parseDouble(tempString);
            } else {
                throw new Exception("Temperature data not found in the response.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cityTemp;
    }
}
