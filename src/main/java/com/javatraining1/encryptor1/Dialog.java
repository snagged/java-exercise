package com.javatraining1.encryptor1;

import java.util.Scanner;

public class Dialog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "To encrypt a file enter '0'. To decrypt a file enter '1'."
                        + " To encrypt a folder enter '2'. To decrypt a folder enter '3'.");
        String answer = scanner.next();
        FileEncryptor fileEncryptor = new FileEncryptor(
                new DoubleEncryption(new ShiftUpEncryption()));

        if (answer.equals("0")) {
            System.out.println("File encryption selected.");
            System.out.println("Please enter path to source file.");
            String pathToSource = scanner.next();
            String ciphertext_path = FileOperations.format(pathToSource,
                    "_encrypted");
            String key_path = pathToSource
                    .substring(0, pathToSource.lastIndexOf(92) + 1)
                    .concat("key.txt");
            try {
                fileEncryptor.encryptFile(pathToSource, ciphertext_path,
                        key_path);
            } catch (InvalidPathException e) {
                System.err.println("InvalidPathException: " + e.getMessage());
                scanner.close();
                return;
            }
        }

        else if (answer.equals("1")) {
            System.out.println("File decryption selected.");
            System.out.println("Please enter path to encrypted file.");
            String pathToCipher = scanner.next();
            String plaintext_path = FileOperations.format(pathToCipher,
                    "_decrypted");
            System.out.println("Please enter path to key file.");
            String key_path = scanner.next();
            try {
                fileEncryptor.decryptFile(pathToCipher, plaintext_path,
                        key_path);
            } catch (InvalidPathException e) {
                System.err.println("InvalidPathException: " + e.getMessage());
                scanner.close();
                return;
            } catch (InvalidEncryptionKeyException e) {
                System.err.println(
                        "InvalidEncryptionKeyException: " + e.getMessage());
                scanner.close();
                return;
            }
        } else if (answer.equals("2")) {
            System.out.println("Folder encryption selected.");
            System.out.println("Please enter path to folder to encrypt.");
            String pathToFolder = scanner.next();
            AsyncDirectoryProcessor async = new AsyncDirectoryProcessor(
                    fileEncryptor);
            try {
                async.encryptDirectory(pathToFolder);
            } catch (InvalidPathException e) {
                System.err.println("InvalidPathException: " + e.getMessage());
                scanner.close();
                return;
            } catch (InvalidEncryptionKeyException e) {
                System.err.println(
                        "InvalidEncryptionKeyException: " + e.getMessage());
                scanner.close();
                return;
            } catch (InterruptedException e) {
                System.err.println("InterruptedException: " + e.getMessage());
                scanner.close();
                return;
            }
        } else if (answer.equals("3")) {
            System.out.println("Folder decryption selected.");
            System.out.println("Please enter path to folder to decrypt.");
            String pathToFolder = scanner.next();
            AsyncDirectoryProcessor async = new AsyncDirectoryProcessor(
                    fileEncryptor);
            try {
                async.decryptDirectory(pathToFolder);
            } catch (InvalidPathException e) {
                System.err.println(
                        "InvalidPathException: " + e.getMessage());
                scanner.close();
                return;
            } catch (InvalidEncryptionKeyException e) {
                System.err.println(
                        "InvalidEncryptionKeyException: " + e.getMessage());
                scanner.close();
                return;
            } catch (InterruptedException e) {
                System.err.println("InterruptedException: " + e.getMessage());
                scanner.close();
                return;
            }
        } else if (answer.equals("4")) {
            System.out.println("Folder encryption selected, sync.");
            System.out.println("Please enter path to folder to encrypt.");
            String pathToFolder = scanner.next();
            SyncDirectoryProcessor async = new SyncDirectoryProcessor(
                    fileEncryptor);
            try {
                async.encryptDirectory(pathToFolder);
            } catch (InvalidPathException e) {
                System.err.println("InvalidPathException: " + e.getMessage());
                scanner.close();
                return;
            } catch (InvalidEncryptionKeyException e) {
                System.err.println(
                        "InvalidEncryptionKeyException: " + e.getMessage());
                scanner.close();
                return;
            }

        } else if (answer.equals("5")) {
            System.out.println("Folder decryption selected, sync.");
            System.out.println("Please enter path to folder to decrypt.");
            String pathToFolder = scanner.next();
            SyncDirectoryProcessor async = new SyncDirectoryProcessor(
                    fileEncryptor);
            try {
                async.decryptDirectory(pathToFolder);
            } catch (InvalidPathException e) {
                System.err.println(
                        "InvalidPathException: " + e.getMessage());
                scanner.close();
                return;
            } catch (InvalidEncryptionKeyException e) {
                System.err.println(
                        "InvalidEncryptionKeyException: " + e.getMessage());
                scanner.close();
                return;
            }

        } else {
            System.out.println(
                    "Input was not '0', '1', '2' or '3'. Terminating.");
        }
        scanner.close();
    }
}
