package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.IOException;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws FileIsNotAvailableException, IOException {
        URL url = new URL(String.format("https://http.cat/%d.jpg", code));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if (responseCode == 404) {
            throw new FileIsNotAvailableException();
        }
        return url.toString();
    }



    public static void main(String[] args) throws FileIsNotAvailableException, IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        checker.getStatusImage(200);
        checker.getStatusImage(4000);
    }
}
