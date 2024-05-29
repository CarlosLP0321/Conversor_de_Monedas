import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SolicitudAPI {
    public void Convertir(String monedaBase, String monedaObjetivo, int cantidadConvertir) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/d526fc1dbff44099e95590b8/pair/"+
                monedaBase+"/"+
                monedaObjetivo+"/"+
                cantidadConvertir;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
    }
}
