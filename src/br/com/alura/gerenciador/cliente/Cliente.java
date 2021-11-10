package br.com.alura.gerenciador.cliente;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Cliente {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault(); 
		
		HttpGet request = new HttpGet("http://localhost:8080/gerenciador/empresas");
		request.addHeader("accept", "application/json");
		
		CloseableHttpResponse response = httpClient.execute(request);
		
		// Get HttpResponse Status
        System.out.println(response.getProtocolVersion());              // HTTP/1.1
        System.out.println(response.getStatusLine().getStatusCode());   // 200
        System.out.println(response.getStatusLine().getReasonPhrase()); // OK
        System.out.println(response.getStatusLine().toString()); 
        
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // return it as a String
            String result = EntityUtils.toString(entity);
            System.out.println(result);
        }

	}

}
