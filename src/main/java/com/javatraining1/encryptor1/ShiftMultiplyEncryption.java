package com.javatraining1.encryptor1;

public class ShiftMultiplyEncryption extends SimpleEncryption
        implements EncryptionAlgorithm {
    public int operation(char c, int i) {
        return (int) (c * i);
    }

    public int reverseOperation(Integer c, int i) {
        return (int) (c / i);
    }

    public int getKeyStrength() {
        return 10;
    }

    public String getName() {
        return "Shift Multiply Encryption";
    }
}
