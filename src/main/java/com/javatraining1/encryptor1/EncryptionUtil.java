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

    public static String genericEncrypt(String plaintext, int key, int x) {
        StringBuilder sb = new StringBuilder(plaintext.length());
        for (int i = 0; i < plaintext.length(); i++) {
            if (x == 0) {
                // shift multiply encryption
                sb.append((int) (plaintext.charAt(i) * key));
            } else if (x == 1) {
                // shift up encryption
                sb.append((int) (plaintext.charAt(i) + key));
            } else if (x == 2) {
                // xor encryption
                sb.append((int) ((short) plaintext.charAt(i) ^ (short) key));
            }
            sb.append('.');
        }
        return sb.toString();
    }

    public static String genericDecrypt(String ciphertext, int key, int x) {
        StringBuilder sb = new StringBuilder(ciphertext.length());
        Vector<Integer> wholeChars = EncryptionUtil.reform(ciphertext);
        for (int i = 0; i < wholeChars.size(); i++) {
            if (x == 0) {// shift multiply encryption
                sb.append((char) (wholeChars.elementAt(i) / key));
            } else if (x == 1) {// shift up encryption
                sb.append((char) (wholeChars.elementAt(i) - key));
            } else if (x == 2) {// xor encryption
                sb.append((char) ((short) (int) wholeChars.elementAt(i)
                        ^ (short) key));
            }
        }
        return sb.toString();
    }
}
