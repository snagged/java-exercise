package com.javatraining1.encryptor1;

public class RepeatEncryption implements EncryptionAlgorithm {
    private EncryptionAlgorithm EncryptionAlgorithm;
    private int n;

    public RepeatEncryption(EncryptionAlgorithm EA, int n) {
        this.EncryptionAlgorithm = EA;
        this.n = n;
    }

    public String encrypt(String plaintext, Key key) {
        for (int i = 0; i < n; i++) {
            plaintext = EncryptionAlgorithm.encrypt(plaintext, key);
        }
        return plaintext;
    }

    public String decrypt(String ciphertext, Key key) {
        for (int i = 0; i < n; i++) {
            ciphertext = EncryptionAlgorithm.decrypt(ciphertext, key);
        }
        return ciphertext;
    }

    public int getKeyStrength() {
        return EncryptionAlgorithm.getKeyStrength();
    }

    public String getName() {
        return "Repeat Encryption";
    }
}
