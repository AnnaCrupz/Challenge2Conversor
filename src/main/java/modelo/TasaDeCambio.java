package modelo;

import java.io.IOException;
import java.io.Reader;
//import org.json.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.*;
import com.google.gson.*;

public class TasaDeCambio {
    public double convertirDivisa(String from, String to, double amount) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        double valor = 0.0;
        String cadena = null;
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount)
                .addHeader("apikey", "0WOrwY2KD8MuYp01udBDSKpka581AAVS")
                .method("GET", null)
                .build();
        System.out.println(request);
        Response response;
        try {
            response = client.newCall(request).execute();
            cadena = response.body().string();

            // Procesar la respuesta JSON
            JSONObject jsonResponse = new JSONObject(cadena);

            // Acceder a los datos de la respuesta
            valor = jsonResponse.getDouble("result");
                  

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(valor==0.0) {
        	valor=(Double) null;
        	return valor;
        }
        
        return valor;
    }
}
