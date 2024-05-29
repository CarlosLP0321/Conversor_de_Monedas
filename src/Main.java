import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SolicitudAPI solicitud = new SolicitudAPI();
        Scanner lectura = new Scanner(System.in);

        int cantidadConvertir;
        boolean bucle = true;

        System.out.println("""
                **************************\
                
                |Bienvedi@ al Conversor de Moneda|\
                
                1) Dólar ==>> Peso Argentino\

                2) Peso Argentino ==>> Dólar\

                3) Dólar ==>> Real brasileño\

                4) Real brasileño ==>> Dólar\

                5) Dólar ==>> Peso colombiano\

                6) Peso colombiano ==>> Dólar\

                7) Dólar ==>> Quetzal guatemalteco\

                8) Quetzal guatemalteco ==>> Dólar\

                9) Salir""");

        while (bucle){
            System.out.println("Elija una opción válida: ");
            var opcion = lectura.nextInt();
            System.out.println("**************************");

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("USD","ARS",cantidadConvertir);
                    break;

                case 2:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("ARS","USD",cantidadConvertir);
                    break;

                case 3:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("USD","BRL",cantidadConvertir);
                    break;

                case 4:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("BRL","USD",cantidadConvertir);
                    break;

                case 5:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("USD","COP",cantidadConvertir);
                    break;

                case 6:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("COP","USD",cantidadConvertir);
                    break;

                case 7:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("USD","GTQ",cantidadConvertir);
                    break;

                case 8:
                    System.out.println("Ingrese el valor que desea convertir:");
                    cantidadConvertir = lectura.nextInt();
                    solicitud.Convertir("GTQ","USD",cantidadConvertir);
                    break;

                case 9:
                    bucle = false;
                    break;
            }
        }
    }
}