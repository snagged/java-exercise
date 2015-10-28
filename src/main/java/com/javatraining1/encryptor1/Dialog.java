package com.javatraining1.encryptor1;

import java.io.IOException;
import java.util.Scanner;

public class Dialog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To encrypt enter '0'. To decrypt enter '1'.");
        String answer = scanner.next();
        FileEncryptor FE = new FileEncryptor(
                new DoubleEncryption(new ShiftUpEncryption()));

        if (answer.equals("0")) {
            System.out.println("Encryption selected.");
            System.out.println("Please enter path to source file.");
            String path = scanner.next();
            String ciphertext_path = FileOperations.format(path, "_encrypted");
            String key_path = path.substring(0, path.lastIndexOf(92) + 1)
                    .concat("key.txt");
            try {
                FE.encryptFile(path, ciphertext_path, key_path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (answer.equals("1")) {
            System.out.println("Decryption selected.");
            System.out.println("Please enter path to encrypted file.");
            String path = scanner.next();
            String plaintext_path = FileOperations.format(path, "_decrypted");
            System.out.println("Please enter path to key file.");
            String key_path = scanner.next();
            try {
                FE.decryptFile(path, plaintext_path, key_path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else
            System.out.println("Input was not '0' or '1'. Terminating.");
        scanner.close();
    }
}
