import com.google.gson.JsonObject;

public class Moneda {
    private final String monedaBase;
    private final JsonObject tasasConversiones;

    public Moneda(InfoMoneda infoMoneda){
        this.monedaBase = infoMoneda.base_code();
        this.tasasConversiones = infoMoneda.conversion_rates();
    }

    public double getTasaConversion(String codigo_moneda) {
        return tasasConversiones.get(codigo_moneda).getAsDouble();
    }

    @Override
    public String toString() {
        return "(base=" + monedaBase +
                ", conversiones=" + tasasConversiones +
                ")";
    }
}
