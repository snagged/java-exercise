package com.javatraining1.encryptor1;

import java.util.concurrent.Callable;

public class DecryptFileRunnable implements Callable<Void> {
    private FileEncryptor fileEncryptor;
    private String originalFilePath;
    private String outputPath;
    private String keyPath;

    public DecryptFileRunnable(String originalFilePath, String outputPath,
            String keyPath, FileEncryptor fileEncryptor) {
        this.originalFilePath = originalFilePath;
        this.outputPath = outputPath;
        this.keyPath = keyPath;
        this.fileEncryptor = fileEncryptor;
    }

    @Override
    public Void call() throws Exception {
        fileEncryptor.decryptFile(originalFilePath, outputPath, keyPath);
        return null;
    }

}
