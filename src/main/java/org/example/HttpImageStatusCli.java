package org.example;
import java.io.IOException;
import java.util.Scanner;
public class HttpImageStatusCli {

    public void askStatus() throws FileIsNotAvailableException, IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter HTTP status code");

            try {
                String input = scanner.nextLine();
                int code = Integer.parseInt(input);
                HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
                downloader.downloadStatusImage(code);
                System.out.println("Entered HTTP status code " + input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static void main(String [] args) throws FileIsNotAvailableException, IOException {
        HttpImageStatusCli statusCli = new HttpImageStatusCli();
        statusCli.askStatus();
    }
    }

