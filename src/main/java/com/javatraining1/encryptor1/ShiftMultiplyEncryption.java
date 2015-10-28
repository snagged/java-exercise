package com.javatraining1.encryptor1;

public class ShiftMultiplyEncryption implements EncryptionAlgorithm {
    public String encrypt(String plaintext, int key) {
        return EncryptionUtil.genericEncrypt(plaintext, key, 0);
    }

    public String decrypt(String ciphertext, int key) {
        return EncryptionUtil.genericDecrypt(ciphertext, key, 0);
    }
}
