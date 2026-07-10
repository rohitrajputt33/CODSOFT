package task4_currency_converter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    // A free exchange rate API endpoint
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Currency Converter ---");

        try {
            System.out.print("Enter the base currency code (e.g., USD, EUR, INR): ");
            String baseCurrency = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter the target currency code (e.g., USD, EUR, INR): ");
            String targetCurrency = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter the amount to convert: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount < 0) {
                System.out.println("Amount cannot be negative.");
                return;
            }

            double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
            if (exchangeRate != -1) {
                double convertedAmount = amount * exchangeRate;
                System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
            } else {
                System.out.println("Failed to fetch exchange rate. Please check your currency codes or internet connection.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered. Please enter a numerical value.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double fetchExchangeRate(String base, String target) {
        try {
            URL url = new URL(API_URL + base);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Simple JSON parsing to avoid third-party dependencies (like Gson or Jackson)
                // since this is a basic script.
                String jsonStr = response.toString();
                String targetKey = "\"" + target + "\":";
                int targetIndex = jsonStr.indexOf(targetKey);

                if (targetIndex != -1) {
                    int startIndex = targetIndex + targetKey.length();
                    int endIndex = jsonStr.indexOf(",", startIndex);
                    if (endIndex == -1) {
                        endIndex = jsonStr.indexOf("}", startIndex);
                    }
                    String rateStr = jsonStr.substring(startIndex, endIndex).trim();
                    return Double.parseDouble(rateStr);
                }
            }
        } catch (Exception e) {
            // Silently fall through to return -1 indicating failure
        }
        return -1;
    }
}
