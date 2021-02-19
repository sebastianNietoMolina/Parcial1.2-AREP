package edu.escuelaing.arep.app;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App{

    /**
     *El metodo mean permite iniciar el programa cuando este es ejecutado.
     * @param args
     */
    public static void main(String[] args) {
        staticFileLocation("/static");
        port(getPort());
        get("/trigonometrica",(req, res) -> conectar(req, res));
    }

    /**
     * La clase fachada conecta se conecta con la api creada anteoriomente para hacer las operaciones.
     * @param req
     * @param res
     * @return
     */
    static String conectar(Request req, Response res){
        String tipo = req.queryParams("tipo");
        String num = req.queryParams("num");
        FachadaConectaConOtroConeccion fachada = new FachadaConectaConOtroConeccion();
        String mostrar = fachada.getTrigonometrica(num, tipo);
        return mostrar;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36500;
    }



}
