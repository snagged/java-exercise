package com.javatraining1.encryptor1;

public interface EncryptionAlgorithm {
    public String encrypt(String plaintext, int key);

    public String decrypt(String ciphertext, int key);
}