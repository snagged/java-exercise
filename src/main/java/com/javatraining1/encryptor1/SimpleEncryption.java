package com.javatraining1.encryptor1;

public abstract class SimpleEncryption {// xor, shiftup or shiftmultiply
                                        // encryptions

    public String encrypt(String plaintext, Key key) {
        return EncryptionUtil.genericEncrypt(plaintext, key, this);
    }

    public String decrypt(String ciphertext, Key key) {
        return EncryptionUtil.genericDecrypt(ciphertext, key, this);
    }

    abstract int operation(char c, int i);

    abstract int reverseOperation(Integer c, int i);

}