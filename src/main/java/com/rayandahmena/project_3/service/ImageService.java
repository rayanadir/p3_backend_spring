package com.rayandahmena.project_3.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class that handles images
 */
@Service
public class ImageService {

    /**
     * Loads an image, takes a file as a param
     * @param file
     * @return String (file name)
     * @throws IOException
     */
    public String loadImage(MultipartFile file) throws IOException{
        String path = "static";
        Path uploadPath = Paths.get(path);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Original file as string
        String initialFile = Objects.requireNonNull(file.getOriginalFilename());
        String fileName = StringUtils.cleanPath(initialFile);

        // Convert string picture to file
        File pictureFile = new File(path + "/" + fileName);
        file.transferTo(pictureFile.toPath());

        return fileName;

    }
}
