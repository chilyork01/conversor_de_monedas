import com.google.gson.Gson;
import java.util.Map;

class main {
    public static void main(String[] args) {
        String jsonResponse = "{ ... }"; // Tu JSON aquí.

        // Deserializar el JSON a un objeto ExchangeRateResponse
        Gson gson = new Gson();
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(jsonResponse, ExchangeRateResponse.class);

        // Obtener tasa de cambio para una moneda en particular
        Map<String, Double> conversionRates = exchangeRateResponse.getConversion_rates();
        double usdToEur = conversionRates.get("EUR");
        System.out.println("Tasa de USD a EUR: " + usdToEur);

        // Puedes hacer lo mismo para otras monedas
        double usdToJpy = conversionRates.get("JPY");
        System.out.println("Tasa de USD a JPY: " + usdToJpy);
    }
}
