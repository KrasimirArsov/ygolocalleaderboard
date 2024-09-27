package com.k.arsov.ygolocalleaderboard.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.net.MalformedURLException;
import java.io.IOException;

@Service
public class ImageService {

    // Directory where images are stored
    private final Path imageStorageLocation;

    public ImageService() {
        // Set the base directory where images are stored (you can configure this path)
        this.imageStorageLocation = Paths.get("E:\\YGOLocalLeaderboardImages\\card_image_small").toAbsolutePath().normalize();
    }

    /**
     * Load an image by file name from the file system.
     * @param fileName The name of the image file.
     * @return Resource pointing to the image file.
     * @throws RuntimeException if the file is not found or cannot be accessed.
     */
    public Resource loadImage(String fileName) {
        try {
            // Clean the path to prevent directory traversal attacks
            Path filePath = imageStorageLocation.resolve(fileName + ".jpg").normalize();

            // Check if the file exists and is readable
            if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
                throw new RuntimeException("File not found or not readable: " + fileName);
            }

            // Convert the file path to a UrlResource
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error retrieving file: " + fileName, e);
        }
    }
}