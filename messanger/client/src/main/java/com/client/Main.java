package com.client;

import com.client.console.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu.show();
        /*
        CloseableHttpClient httpClient = ClientBuilder.create().setMaxPoolSize(8192).build();
        HttpRequest httpRequest = HttpRequestBuilder.create(httpClient).build();
        Response response = httpRequest.target("http://localhost:8080/api/account/all").get();
        System.out.println("Answer: " + response.readEntity(new TypeReference<List<String>>() {})); // Чтение
        */
    }
}
