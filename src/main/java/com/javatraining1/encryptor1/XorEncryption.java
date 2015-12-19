package com.javatraining1.encryptor1;

public class XorEncryption extends SimpleEncryption
        implements EncryptionAlgorithm {

    public int operation(char c, int i) {
        return (int) ((short) c ^ (short) i);
    }

    public int reverseOperation(Integer c, int i) {
        return (int) ((short) (int) c ^ (short) i);
    }

    public int getKeyStrength() {
        return 5;
    }

    public String getName() {
        return "Xor Encryption";
    }
}
