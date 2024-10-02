package com.k.arsov.ygolocalleaderboard.rest;

import com.k.arsov.ygolocalleaderboard.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/{imageFileName}")
    public ResponseEntity<Resource> getCardImageById(@PathVariable String imageFileName) {
        Resource resource = imageService.loadImage("card_image_small\\" + imageFileName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)  // Adjust content type based on your image format
                .body(resource);
    }

    @GetMapping("/avatar/{name}/{state}")
    public ResponseEntity<Resource> getCardImageById(@PathVariable String name, @PathVariable String state) {
        Resource resource = imageService.loadImage("avatar_image\\" + name + "\\" + state);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)  // Adjust content type based on your image format
                .body(resource);
    }
}