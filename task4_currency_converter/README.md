# Task 4: Currency Converter

## Overview
This project is a dynamic currency converter that fetches live exchange rates from the internet to convert user-specified amounts between any supported global currencies (e.g., USD to EUR, INR to GBP).

## Features
- **Live API Integration:** Uses Java's built-in `HttpURLConnection` to make HTTP GET requests to a free exchange rate API (ExchangeRate-API).
- **No Third-Party Dependencies:** Parses the resulting JSON data manually without requiring external libraries like Gson or Jackson, keeping the project lightweight.
- **Error Handling:** Gracefully handles network timeouts, invalid currency codes, and negative input amounts.

## How to Run
Ensure you have an active internet connection (to fetch the live API data) and the Java Development Kit (JDK) installed.

```bash
# Compile
javac task4_currency_converter/*.java

# Run
java task4_currency_converter.CurrencyConverter
```
