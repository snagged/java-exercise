package com.javatraining1.encryptor1;

import java.util.concurrent.Callable;

public class EncryptFileRunnable implements Callable<Void> {
    private FileEncryptor fileEncryptor;
    private String originalFilePath;
    private String outputPath;
    private String keyPath;
    private Key key;

    public EncryptFileRunnable(String originalFilePath, String outputPath,
            String keyPath, Key key, FileEncryptor fileEncryptor) {
        this.originalFilePath = originalFilePath;
        this.outputPath = outputPath;
        this.keyPath = keyPath;
        this.key = key;
        this.fileEncryptor = fileEncryptor;
    }

    @Override
    public Void call() throws Exception {
        fileEncryptor.encryptFile(originalFilePath, outputPath, keyPath, key);
        return null;
    }

}
