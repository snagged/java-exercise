package com.javatraining1.encryptor1;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class FileEncryptor {
    private EncryptionAlgorithm EA;

    public FileEncryptor(EncryptionAlgorithm EA) {
        this.EA = EA;
    }

    public void encryptFile(String originalFilePath, String outputPath,
            String keyPath) throws IOException {
        String plaintext = FileOperations.read(originalFilePath);
        int key = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
        String ciphertext = EA.encrypt(plaintext, key);
        FileOperations.write(ciphertext, outputPath);
        FileOperations.write("" + key, keyPath);
        System.out.println("Location of encrypted file: " + outputPath);
        System.out.println("Location of encryption key: " + keyPath);
    }

    public void decryptFile(String encryptedFilePath, String outputPath,
            String keyPath) throws IOException {
        String ciphertext = FileOperations.read(encryptedFilePath);
        int key = Integer.parseInt(FileOperations.read(keyPath));
        String plaintext = EA.decrypt(ciphertext, key);
        FileOperations.write(plaintext, outputPath);
        System.out.println("Location of decrypted file: " + outputPath);
    }
}