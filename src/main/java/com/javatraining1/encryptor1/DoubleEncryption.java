package com.javatraining1.encryptor1;

public class DoubleEncryption implements EncryptionAlgorithm {
    private EncryptionAlgorithm EncryptionAlgorithm;

    public DoubleEncryption(EncryptionAlgorithm EA) {
        this.EncryptionAlgorithm = EA;
    }

    public String encrypt(String plaintext, Key key) {
        String firstpass = EncryptionAlgorithm.encrypt(plaintext,
                new Key(key.getKey1()));
        return EncryptionAlgorithm.encrypt(firstpass, new Key(key.getKey2()));
    }

    public String decrypt(String ciphertext, Key key) {
        String firstpass = EncryptionAlgorithm.decrypt(ciphertext,
                new Key(key.getKey2()));
        return EncryptionAlgorithm.decrypt(firstpass, new Key(key.getKey1()));
    }

    public int getKeyStrength() {
        return 2 * EncryptionAlgorithm.getKeyStrength();
    }

    public String getName() {
        return "Double Encryption";
    }
}