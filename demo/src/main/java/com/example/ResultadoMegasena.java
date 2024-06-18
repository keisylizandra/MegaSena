package com.example;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * Classe que obtém os números do último sorteio da mega-sena.
 * 
 */

public class ResultadoMegasena {
    /** URL que possui as dezenas sorteadas. */
    private final static String URL = "https://loteriascaixa-api.herokuapp.com/api/megasena/latest";


public static String[] obtemUltimoResultado() {
//Criação do cliente HTTP que fará a conexão com o site
HttpClient httpclient = HttpClients.createDefault();

try {
    // Definição da URL a ser utilizada
    HttpGet httpget = new HttpGet(URL);
    // Manipulador da resposta da conexão com a URL
    ResponseHandler<String> responseHandler = new BasicResponseHandler();
    // Resposta propriamente dita
    String json = httpclient.execute(httpget, responseHandler);

    //Retorno das dezenas, após tratamento
    return obterDezenas(json);

} catch (Exception e) {
// Caso haja erro, dispara exceção.
throw new RuntimeException("Um erro inesperado ocorreu.", e);
} 
}
    /**
     * Tratamento da resposta JSON obtida pelo método
     * obtemUltimoResultado().
     * @return array de Strings, onde cada elemento é uma dezena
     *         sorteada.
     */
    private static String[] obterDezenas(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray dezenas = jsonObject.getJSONArray("dezenas");
        String[] array = new String[dezenas.length()];
        for (int i = 0; i < dezenas.length(); i++){
            array[i] = dezenas.getString(i);
        }
        return array;
    }
}