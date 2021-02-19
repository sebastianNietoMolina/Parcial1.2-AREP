package edu.escuelaing.arep.app;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Scanner;

public class Cliente {

    /**
     * Metodo que permite hacer el calculo desde el cliente.
     * @param args
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();
        String tipo = myObj.nextLine();
        System.out.println(getTrigonometrica(num, tipo));
    }

    /**
     * Lee del api fachada, que esta en App.
     * @param num
     * @param tipo
     * @return
     */
    public static String getTrigonometrica(String num, String tipo) {
        Request request = new Request.Builder()
                .url("https://parcial1fachadaarepsebastinto.herokuapp.com//trigonometrica?num="+num+"&tipo="+tipo)
                .get()
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        String datos = null;
        Response res = null;

        try {
            res = httpClient.newCall(request).execute();
            if (res.isSuccessful()) {
                datos = res.body().string();
            }
        } catch (IOException e) {
            System.out.println("Fallo");
        }

        String mostrar = datos;
        return mostrar;
    }
}
