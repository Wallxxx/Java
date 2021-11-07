package com.client.messages;

import com.client.auth.AuthMe;
import com.client.items.ListItem;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsunsoft.http.*;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.List;

public class Messages {

    private final static CloseableHttpClient httpClient = ClientBuilder.create().setMaxPoolSize(8192).build();
    private final static HttpRequest httpRequest = HttpRequestBuilder.create(httpClient).build();

    public static boolean send(String address, String message) { // TODO: Реализовать отправку с пробелами
        if (address == null || AuthMe.getLogin() == null || AuthMe.getPassword() == null) return false;
        Response response = httpRequest.target("http://localhost:8080/api/message/send/" +
                AuthMe.getLogin() + "&" + AuthMe.getPassword() + "&" + address + "&" + message).put();
        return response.getStatusCode() == 200;
    }

    public static List<ListItem> getMessages() {
        if (AuthMe.getLogin() == null || AuthMe.getPassword() == null) return null;
        Response response = httpRequest.target("http://localhost:8080/api/message/update/" +
                AuthMe.getLogin() + "&" + AuthMe.getPassword()).get();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return response.readEntity(new TypeReference<List<ListItem>>() {});
    }
}
