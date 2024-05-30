import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static double convertirMoneda(double cantidadAConvertir, double tasaCambio) {
        return cantidadAConvertir * tasaCambio;
    }

    public static void procesoConvertirMoneda(String monedaBase, String monedaObjetivo, Moneda moneda){
        Scanner lectura = new Scanner(System.in);
        double tasaCambio;
        double cantidadAConvertir;
        double cantidadConvertida;

        if (Objects.equals(monedaObjetivo, "USD")){
            tasaCambio = 1 / moneda.getTasaConversion(monedaBase);
        } else {
            tasaCambio = moneda.getTasaConversion(monedaObjetivo);
        }

        System.out.println("Tasa de Cambio: " + String.format("%.4f", tasaCambio) + " [" + monedaObjetivo + "]\n");

        System.out.println("Ingrese el valor que desea convertir:");
        cantidadAConvertir = lectura.nextDouble();

        cantidadConvertida = convertirMoneda(cantidadAConvertir, tasaCambio);

        System.out.println("\nEl valor " + cantidadAConvertir + " [" + monedaBase +
                "] corresponde al valor final de ==>> " + cantidadConvertida + " [" + monedaObjetivo +
                "]\n**************************");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SolicitudAPI solicitud = new SolicitudAPI();
        ManejadorJSON manejadorJSON = new ManejadorJSON();
        Scanner lectura = new Scanner(System.in);

        String json;
        String monedaBase;
        String monedaObjetivo;
        boolean bucle = true;

        System.out.println("""
                **************************\
                
                |Bienvedi@ al Conversor de Moneda|\
                
                1) Dólar(USD) ==>> Peso Argentino(ARS)\

                2) Peso Argentino(ARS) ==>> Dólar(USD)\

                3) Dólar(USD) ==>> Real brasileño(BRL)\

                4) Real brasileño(BRL) ==>> Dólar(USD)\

                5) Dólar(USD) ==>> Peso colombiano(COP)\

                6) Peso colombiano(COP) ==>> Dólar(USD)\

                7) Dólar(USD) ==>> Quetzal guatemalteco(GTQ)\

                8) Quetzal guatemalteco(GTQ) ==>> Dólar(USD)\

                9) Salir""");

        json = solicitud.Convertir("USD");
        Moneda moneda = new Moneda(manejadorJSON.Respuesta(json));

        while (bucle){
            int opcion = 10;
            try {
                System.out.println("\nElija una opción válida: ");
                opcion = lectura.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nPor favor ingresar una opción válida");
                lectura.nextLine();
            }finally {
                System.out.println("\n**************************");
            }

            switch (opcion) {
                case 1:
                    monedaBase = "USD";
                    monedaObjetivo = "ARS";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 2:
                    monedaBase = "ARS";
                    monedaObjetivo = "USD";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 3:
                    monedaBase = "USD";
                    monedaObjetivo = "BRL";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 4:
                    monedaBase = "BRL";
                    monedaObjetivo = "USD";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 5:
                    monedaBase = "USD";
                    monedaObjetivo = "COP";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 6:
                    monedaBase = "COP";
                    monedaObjetivo = "USD";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 7:
                    monedaBase = "USD";
                    monedaObjetivo = "GTQ";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 8:
                    monedaBase = "GTQ";
                    monedaObjetivo = "USD";
                    procesoConvertirMoneda(monedaBase, monedaObjetivo, moneda);
                    break;

                case 9:
                    bucle = false;
                    break;
            }
        }
    }
}