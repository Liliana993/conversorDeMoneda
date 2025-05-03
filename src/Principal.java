import com.google.gson.Gson;
import modelos.ConversorDeMoneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        //declaramos las variables en 0 para iniciar
        double valor = 0;
        int opcion = 0;

        //Colores del menú
        String green="\033[32m";
        String red="\033[31m";


        try{
            while (opcion != 7){
                    conversor.mostrarMenu();
                    System.out.println("Selecciona una opción del menú.");
                    opcion = sc.nextInt();
                    if(opcion != 7){
                    System.out.println("Ingresa el valor a convertir: ");
                    valor = sc.nextDouble();
                    }

                    switch (opcion){
                        case 1:
                            conversor.monedaAConvertir(1, valor, "USD");
                            break;
                        case 2:
                            conversor.monedaAConvertir(2, valor, "ARS");
                            break;
                        case 3:
                            conversor.monedaAConvertir(3, valor, "USD");
                            break;
                        case 4: conversor.monedaAConvertir(4, valor, "BRL");
                            break;
                        case 5: conversor.monedaAConvertir(5, valor, "USD");
                            break;
                        case 6:
                            conversor.monedaAConvertir(6, valor, "COP");
                            break;
                        case 7:
                            System.out.println(green + "Gracias por utilizar nuestros servcios 💱! Cerrando App.");
                }
            }
        }catch (Exception e){
            System.out.println(red + "Ha ocurrido un error: " + e);
        }

    }
}
