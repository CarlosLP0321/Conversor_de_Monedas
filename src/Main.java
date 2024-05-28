import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el codigo 1: ");
        var codigo1 = lectura.nextLine();

        System.out.println("Escriba el codigo 2: ");
        var codigo2 = lectura.nextLine();

        System.out.println("Escriba la cantidad: ");
        var cantidad = lectura.nextLine();

        String direccion = "https://v6.exchangerate-api.com/v6/d526fc1dbff44099e95590b8/pair/"+codigo1+"/"+codigo2+"/"+cantidad;

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