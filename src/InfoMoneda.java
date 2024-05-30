import com.google.gson.JsonObject;

public record InfoMoneda(String base_code, JsonObject conversion_rates) {
}
