package edu.escuelaing.arep.app;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class FachadaConectaConOtroConeccion {

    public FachadaConectaConOtroConeccion() {
    }

    /**
     * Retorna los valores del api creada anteriomente que esta en mi repositorio llamado Parcial1-AREP.
     * @param num
     * @param tipo
     * @return
     */
    public String getTrigonometrica(String num, String tipo) {
        Request request = new Request.Builder()
                .url("https://parcial1arepsebastiannieto.herokuapp.com/trigonometrica?num="+num+"&tipo="+tipo)
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
