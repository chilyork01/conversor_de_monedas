import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String apiKey = "35bf1606618f76a9752b7036";  // Puedes cambiar esto o pedirlo al usuario
        boolean continuar = true;

        while (continuar) {
            // Mostrar menú
            System.out.println("***************************");
            System.out.println("Sea bienvenido/a al conversor de moneda =]");
            System.out.println();
            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Peso Chileno");
            System.out.println("8) Peso Chileno =>> Dólar");
            System.out.println("9) Salir");
            System.out.println();
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt();
            double amount = 0;

            if (opcion >= 1 && opcion <= 8) {
                System.out.print("Ingrese la cantidad de dinero: ");
                amount = scanner.nextDouble();
            }

            String baseCurrency = "";
            String targetCurrency = "";

            switch (opcion) {
                case 1:
                    baseCurrency = "USD";
                    targetCurrency = "ARS";
                    break;
                case 2:
                    baseCurrency = "ARS";
                    targetCurrency = "USD";
                    break;
                case 3:
                    baseCurrency = "USD";
                    targetCurrency = "BRL";
                    break;
                case 4:
                    baseCurrency = "BRL";
                    targetCurrency = "USD";
                    break;
                case 5:
                    baseCurrency = "USD";
                    targetCurrency = "COP";
                    break;
                case 6:
                    baseCurrency = "COP";
                    targetCurrency = "USD";
                    break;
                case 7:
                    baseCurrency = "USD";
                    targetCurrency = "CLP";
                    break;
                case 8:
                    baseCurrency = "CLP";
                    targetCurrency = "USD";
                    break;
                case 9:
                    continuar = false;
                    System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }

            if (opcion >= 1 && opcion <= 8) {
                // Obtener tasa de cambio y realizar la conversión
                ApiClient apiClient = new ApiClient(apiKey);
                double exchangeRate = apiClient.getExchangeRate(baseCurrency, targetCurrency);
                CurrencyConverter converter = new CurrencyConverter();
                double convertedAmount = converter.convert(amount, exchangeRate);

                // Mostrar el resultado
                System.out.println(amount + " " + baseCurrency + " es equivalente a " + convertedAmount + " " + targetCurrency);
                System.out.println("***************************");
            }
        }
        scanner.close();
    }
}
// Clase ApiClient que se encarga de la solicitud HTTP a la API de ExchangeRate
class ApiClient {
    private String apiKey;

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            // Construir la URL para la solicitud de la API
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Procesar la respuesta JSON
            Gson gson = new Gson();
            ApiExchangeRateResponse exchangeRateResponse = gson.fromJson(response.body(), ApiExchangeRateResponse.class);

            // Obtener las tasas de conversión
            Map<String, Double> conversionRates = exchangeRateResponse.getConversion_rates();

            // Retornar la tasa de cambio de la moneda objetivo
            return conversionRates.get(targetCurrency);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

// Clase que realiza la conversión de la moneda
class CurrencyConverter {
    public double convert(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}

// Clase para deserializar la respuesta JSON de la API
class ApiExchangeRateResponse {
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}