package com.javatraining1.encryptor1;

public interface EncryptionAlgorithm {
    public String encrypt(String plaintext, Key key);

    public String decrypt(String ciphertext, Key key);

    public int getKeyStrength();

    public String getName();
}