import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;

public class Weather211 {

    private static final String API_KEY = "33c61ab5246ee1d09c32404ed83bb489";
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";

    public static String getWeatherData(String city) {
        try {
            URI uri = new URI(WEATHER_URL
                    + "?q=" + URLEncoder.encode(city, "UTF-8")
                    + "&appid=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder content = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    return content.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
