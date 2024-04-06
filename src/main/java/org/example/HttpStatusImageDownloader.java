package org.example;

import javax.imageio.ImageIO;
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

        BufferedImage image = ImageIO.read(connection.getInputStream());

        String fileName = "status_" + code + ".jpg";
        File outputFile = new File(fileName);

        ImageIO.write(image, "jpg", outputFile);

    }

    public static void main(String[] args) throws FileIsNotAvailableException, IOException {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        downloader.downloadStatusImage(2000);
    }
}
