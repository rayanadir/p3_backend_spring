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

@Service
public class ImageService {

    public String loadImage(MultipartFile file) throws IOException{
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);
        String path = "static";
        Path uploadPath = Paths.get(path);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String initialFile = Objects.requireNonNull(file.getOriginalFilename());
        String fileName = StringUtils.cleanPath(initialFile);

        File pictureFile = new File(path + "/" + fileName);
        file.transferTo(pictureFile.toPath());

        return fileName;

    }
}
