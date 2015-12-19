package com.javatraining1.encryptor1;

import java.util.Vector;

public class EncryptionUtil {
    public static Vector<Integer> reform(String ciphertext) {// turns dot
        // separated integers into a vector of integers
        Vector<Integer> wholeChars = new Vector<Integer>();// whole characters
                                                           // in integer form
        int charBuilder = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            if (ciphertext.charAt(i) == '.') {// '.' is used a separator between
                                              // integers
                wholeChars.add(charBuilder);
                charBuilder = 0;
            } else {
                charBuilder = charBuilder * 10 + ciphertext.charAt(i) - '0';
            }
        }
        return wholeChars;
    }

    public static String genericEncrypt(String plaintext, Key key,
            SimpleEncryption simpleEncryption) {
        StringBuilder sb = new StringBuilder(plaintext.length());
        for (int i = 0; i < plaintext.length(); i++) {
            sb.append((int) (simpleEncryption.operation(plaintext.charAt(i),
                    key.getKey1())));
            sb.append('.');
        }
        return sb.toString();
    }

    public static String genericDecrypt(String ciphertext, Key key,
            SimpleEncryption simpleEncryption) {
        StringBuilder sb = new StringBuilder(ciphertext.length());
        Vector<Integer> wholeChars = EncryptionUtil.reform(ciphertext);
        for (int i = 0; i < wholeChars.size(); i++) {
            sb.append((char) (simpleEncryption
                    .reverseOperation(wholeChars.elementAt(i), key.getKey1())));
        }
        return sb.toString();
    }
}
