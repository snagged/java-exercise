package com.javatraining1.encryptor1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {
    public static String format(String path, String word) { // [original-file-name]word[original-file-extension]
        return (path.substring(0, path.length() - 4).concat(word)
                .concat(path.substring(path.length() - 4, path.length())));
    }

    public static String read(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }

    public static void write(String text, String text_path) throws IOException {
        Files.write(Paths.get(text_path), text.getBytes());
    }
}
