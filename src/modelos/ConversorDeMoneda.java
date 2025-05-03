package modelos;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorDeMoneda {
    public Moneda filtarMonedas(String conversionBase){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/771ff25bc18886c0318c9223/latest/"+ conversionBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("Lo siento, pero no se logro adquirir el recurso! 😕");
        }
    }
    String blue="\033[34m";

    public void mostrarMenu(){
        System.out.println(blue + '\n'+"""
                Bienvenido a nuestro sistema de conversión ⭐💱
                **********************************************
                1) Dolar => Peso Argentino
                2) Peso argentino => Dolar
                3) Dolar => Real
                4) Real => Dolar
                5) Dolar => Peso colombiano
                6) Peso colombiano => Dolar
                7) Salir
                ***********************************************""");
    }

    public void monedaAConvertir(int opcion, double conversionMoneda, String baseConversion){
        Moneda tasas = filtarMonedas(baseConversion);
        Map<String, Double> conversion = tasas.conversion_rates();
        double resultado;
        Double usdTasa = conversion.get("USD");
        //CREAMOS UN SWITCH PARA RECORRER CADA OPCIÓN DE CAMBIO ELEGIDA POR EL USUARIO
        switch (opcion) {
            case 1:
                Double arsTasa = conversion.get("ARS");
                resultado = conversionMoneda * arsTasa;
                System.out.println("El monto de: " + conversionMoneda + "[USD]. Equivalen a: $" + resultado + "[ARS]");
                break;
            case 2:
                resultado = conversionMoneda * usdTasa;
                System.out.println("El monto de: " + conversionMoneda + "[ARS]. Equivalen a: $" + resultado + "[USD]");
                break;
            case 3:
                Double brlTasa = conversion.get("BRL");
                resultado = conversionMoneda * brlTasa;
                System.out.println("El monto de: " + conversionMoneda + "[USD]. Equivalen a: $" + resultado + "[BRL]");
                break;
            case 4:
                resultado = conversionMoneda * usdTasa;
                System.out.println("El monto de: " + conversionMoneda + "[BRL]. Equivalen a: $" + resultado + "[USD]");
                break;
            case 5:
                Double copTasa = conversion.get("COP");
                resultado = conversionMoneda * copTasa;
                System.out.println("El monto de: " + conversionMoneda + "[USD]. Equivalen a: $" + resultado + "[COP]");
                break;
            case 6:
                resultado = conversionMoneda * usdTasa;
                System.out.println("El monto de: " + conversionMoneda + "[COP]. Equivalen a: $" + resultado + "[USD]");
                break;

        }
    }
}
