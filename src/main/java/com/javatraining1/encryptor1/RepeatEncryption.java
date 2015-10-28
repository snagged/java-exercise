package com.javatraining1.encryptor1;

public class RepeatEncryption implements EncryptionAlgorithm {
    private EncryptionAlgorithm EA;
    private int n;

    public RepeatEncryption(EncryptionAlgorithm EA, int n) {
        this.EA = EA;
        this.n = n;
    }

    public String encrypt(String plaintext, int key) {
        for (int i = 0; i < n; i++) {
            plaintext = EA.encrypt(plaintext, key);
        }
        return plaintext;
    }

    public String decrypt(String ciphertext, int key) {
        for (int i = 0; i < n; i++) {
            ciphertext = EA.decrypt(ciphertext, key);
        }
        return ciphertext;
    }
}
