package com.k.arsov.ygolocalleaderboard.fileloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CardImageDownloader {

    static String downloadDirectory = "E:\\YGOLocalLeaderboardImages\\card_image_small\\";

    public static void main(String[] args) {
        // Path to the file containing the card names and image IDs
        String filePath = "src/main/resources/manual/allCardsPlusImages.txt";

        // Read card data from the file
        downloadCardImages(filePath);
    }

    // Method to read card names and image IDs and download images
    public static void downloadCardImages(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line in the file
            while ((line = br.readLine()) != null) {
                // Split the line into card name and image IDs
                int lastDashIndex = line.lastIndexOf(" - ");
                if (lastDashIndex == -1) {
                    continue; // Skip malformed lines
                }

                // Split the line into card name and image IDs
                String cardName = line.substring(0, lastDashIndex).trim();
                String[] imageIds = line.substring(lastDashIndex + 3).trim().split(",\\s*"); // Split by comma and trim spaces

                // Download images for each ID
                for (String id : imageIds) {
                    downloadImage("https://images.ygoprodeck.com/images/cards_small/" + id + ".jpg", id + ".jpg");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to download a single image from a URL
    public static void downloadImage(String imageUrl, String fileName) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();

            // Check if the request was successful
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Create input stream
                InputStream in = new BufferedInputStream(connection.getInputStream());
                // Create output stream, include the download directory
                FileOutputStream out = new FileOutputStream(downloadDirectory + fileName);

                byte[] buffer = new byte[1024];
                int bytesRead;

                // Read from the input stream and write to the output stream
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                // Close streams
                out.close();
                in.close();

                System.out.println("Downloaded: " + downloadDirectory + fileName);
            } else {
                System.out.println("Failed to download: " + imageUrl);
            }
            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Error downloading image: " + e.getMessage());
        }
    }
}
