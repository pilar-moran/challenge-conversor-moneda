package com.aluracursos.conversordemoneda.servicio;

import com.aluracursos.conversordemoneda.modelo.DatosUsuario;
import com.aluracursos.conversordemoneda.modelo.DatosApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMonedaApi {

   private static final String apiKey = "76bd88105d249d65c781e948";

    public DatosApi consultarApiDeCambio(DatosUsuario datosUsuario) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" +apiKey+ "/pair/" + datosUsuario.base_code() + "/" + datosUsuario.target_code() + "/" + datosUsuario.valorAconvertir() );

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }

        return new Gson().fromJson(response.body(), DatosApi.class);
    }
}
