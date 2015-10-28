package com.javatraining1.encryptor1;

public class DoubleEncryption implements EncryptionAlgorithm {
    private EncryptionAlgorithm EA;

    public DoubleEncryption(EncryptionAlgorithm EA) {
        this.EA = EA;
    }

    public String encrypt(String plaintext, int key) {
        String firstPass = EA.encrypt(plaintext, key);
        return EA.encrypt(firstPass, key + 42);
    }

    public String decrypt(String ciphertext, int key) {
        String firstPass = EA.decrypt(ciphertext, key + 42);
        return EA.decrypt(firstPass, key);
    }
}
