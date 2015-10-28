package com.javatraining1.encryptor1;

public class XorEncryption implements EncryptionAlgorithm {
    public String encrypt(String plaintext, int key) {
        return EncryptionUtil.genericEncrypt(plaintext, key, 2);
    }

    public String decrypt(String ciphertext, int key) {
        return EncryptionUtil.genericDecrypt(ciphertext, key, 2);
    }
}
