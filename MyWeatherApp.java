import java.util.Scanner;

public class MyWeatherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city name:");
        String city = scanner.nextLine();
        scanner.close();

        String weatherDataJson = Weather211.getWeatherData(city);
        if (weatherDataJson != null && weatherDataJson.contains("\"name\":")) {
            try {
                String cityName = extractValue(weatherDataJson, "\"name\":\"", "\",");
                String currentWeather = extractValue(weatherDataJson, "\"description\":\"", "\",");
                double currentTemperature = extractTemperature(weatherDataJson, "\"temp\":");
                double lowTemperature = extractTemperature(weatherDataJson, "\"temp_min\":");
                double highTemperature = extractTemperature(weatherDataJson, "\"temp_max\":");

                System.out.println("City Name: " + cityName);
                System.out.println("Current Weather: " + currentWeather);
                System.out.println("Current Temperature: " + currentTemperature + "°C");
                System.out.println("Low Temperature: " + lowTemperature + "°C");
                System.out.println("High Temperature: " + highTemperature + "°C");
            } catch (Exception e) {
                System.out.println("Error parsing weather data.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Error fetching weather data.");
        }
    }

    private static String extractValue(String json, String key, String endDelimiter) {
        int startIndex = json.indexOf(key) + key.length();
        int endIndex = json.indexOf(endDelimiter, startIndex);
        return json.substring(startIndex, endIndex);
    }

    private static double extractTemperature(String json, String key) {
        int startIndex = json.indexOf(key) + key.length();
        int endIndex = json.indexOf(",", startIndex);
        return Double.parseDouble(json.substring(startIndex, endIndex));
    }
}
