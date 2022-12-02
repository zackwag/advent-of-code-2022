package com.zackwag.advent.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {

    private Util() {
    }

    public static String readFileToString(String filePath) {

        Path path = Paths.get(filePath);
        byte[] fileBytes = null;

        try {
            fileBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.print(String.format("Error reading file as string filePath=%s", filePath));
            return null;
        }

        return new String(fileBytes);
    }
}
