package com.client.auth;

import com.jsunsoft.http.ClientBuilder;
import com.jsunsoft.http.HttpRequest;
import com.jsunsoft.http.HttpRequestBuilder;
import com.jsunsoft.http.Response;
import org.apache.http.impl.client.CloseableHttpClient;

public class AuthMe {

    private final static CloseableHttpClient httpClient = ClientBuilder.create().setMaxPoolSize(8192).build();
    private final static HttpRequest httpRequest = HttpRequestBuilder.create(httpClient).build();

    private static String login;
    private static String password;

    public static String getLogin() {
        return login;
    }
    public static String getPassword() {
        return password;
    }

    public static boolean auth(String userLogin, String userPassword) {
        if (userLogin.length() < 1 || userPassword.length() < 1) {
            return false;
        }
        System.out.print("\n    Connection... ");
        Response response = httpRequest.target("http://localhost:8080/api/account/auth/" +
                userLogin + "&" + userPassword).get();
        System.out.println("success. \n");
        if (response.getStatusCode() == 202) {
            login = userLogin;
            password = userPassword;
            return true;
        }
        else return false;
    }

    public static boolean register(String userLogin, String userPassword) {
        if (userLogin.length() < 1 || userPassword.length() < 1) {
            return false;
        }
        System.out.print("\n    Connection... ");
        Response response = httpRequest.target("http://localhost:8080/api/account/register/" +
                userLogin + "&" + userPassword).put();
        System.out.println("success. \n");
        if (response.getStatusCode() == 200) {
            login = userLogin;
            password = userPassword;
            return true;
        }
        else return false;
    }

    public static void logout() {
        login = null;
        password = null;
    }
}
