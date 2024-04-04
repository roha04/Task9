package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws FileIsNotAvailableException, IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedImage image = ImageIO.read(connection.getInputStream());

            String fileName = "status_" + code + ".jpg";
            File outputFile = new File(fileName);

            ImageIO.write(image, "jpg", outputFile);

            System.out.println("Image downloaded and saved as: " + outputFile.getAbsolutePath());
        } else {
            throw new FileIsNotAvailableException();
        }
    }
    public static void main(String[] args) {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        try {
            downloader.downloadStatusImage(200);
        } catch (IOException | FileIsNotAvailableException e) {
            e.printStackTrace();
        }
    }
}
