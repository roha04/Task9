package org.example;

import java.io.File;
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
        System.out.println("Response code of the object is " + responseCode);

        if (responseCode == 200) {
             url = url;
        } else if (responseCode == 404) {
            throw new FileIsNotAvailableException();
        }
        return url.toString();
    }

    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            System.out.println(checker.getStatusImage(200)); // Should work
            //System.out.println(checker.getStatusImage(10000)); // Should throw an exception
        } catch (IOException | FileIsNotAvailableException e) {
            e.printStackTrace();
        }
    }
}
