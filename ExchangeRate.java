import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Class for retrieving exchange rates
public class ExchangeRate {

    // Method to retrieve exchange rate for a given currency code
    public static double getRate(String currencyCode) throws Exception {
        double rate = 1.0;

        try {
            // Construct URL for exchange rate API
            String firstPartURL = "https://v6.exchangerate-api.com/v6/";
            String key = "a7830972f0cd612e48ccb2ec";
            String thirdPartURL = "/latest/USD";
            String theURL = firstPartURL + key + thirdPartURL;

            URL url = new URL(theURL);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                // Read JSON response from the API
                StringBuilder responseBuilder = new StringBuilder();
                String inputLine;

                while ((inputLine = br.readLine()) != null) {
                    responseBuilder.append(inputLine);
                }

                String jsonResponse = responseBuilder.toString();

                // Extract rate value using regex
                Pattern pattern = Pattern.compile("\"" + currencyCode + "\":(\\d+\\.?\\d*)");
                Matcher matcher = pattern.matcher(jsonResponse);

                // Parse the rate value from the JSON response
                if (matcher.find()) {
                    rate = Double.parseDouble(matcher.group(1));
                } else {
                    throw new Exception("Exchange rate for " + currencyCode + " not found in JSON response");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error retrieving exchange rate: " + ex.getMessage());
        }

        return rate;
    }
}
