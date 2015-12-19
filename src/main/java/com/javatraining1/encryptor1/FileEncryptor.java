package com.javatraining1.encryptor1;

import java.io.File;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Observer;

public class FileEncryptor extends Observable {
    private EncryptionAlgorithm encryptionAlgorithm;
    private boolean isDoubleEncryption = false;

    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    public boolean isDoubleEncryption() {
        return isDoubleEncryption;
    }

    private Observer encryptionLogger;

    public FileEncryptor(EncryptionAlgorithm EA) {
        this.encryptionAlgorithm = EA;
        this.encryptionLogger = new EncryptionLogger();
        this.addObserver(encryptionLogger);
    }

    public FileEncryptor(DoubleEncryption DE) {
        this.encryptionAlgorithm = DE;
        this.isDoubleEncryption = true;
        this.encryptionLogger = new EncryptionLogger();
        this.addObserver(encryptionLogger);
    }

    public FileEncryptor(FileEncryptor fileEncryptor) {
        this.encryptionAlgorithm = fileEncryptor.getEncryptionAlgorithm();
        this.isDoubleEncryption = fileEncryptor.isDoubleEncryption();
        this.encryptionLogger = new EncryptionLogger();
        this.addObserver(encryptionLogger);
    }

    public void encryptFile(String originalFilePath, String outputPath,
            String keyPath) throws InvalidPathException {
        notify(originalFilePath, 1);
        Key key = new Key(isDoubleEncryption);
        String plaintext = FileOperations.read(originalFilePath);
        String ciphertext = encryptionAlgorithm.encrypt(plaintext, key);
        if (isDoubleEncryption) {
            FileOperations.write(key.getKey1() + "." + key.getKey2(), keyPath);
        } else {
            FileOperations.write("" + key.getKey1(), keyPath);
        }
        FileOperations.write(ciphertext, outputPath);
        System.out.println("Location of encrypted file: " + outputPath);
        System.out.println("Location of encryption key: " + keyPath);
        notify(outputPath, 2);
    }

    public void encryptFile(String originalFilePath, String outputPath,
            String keyPath, Key key) throws InvalidPathException {
        notify(originalFilePath, 1);
        String plaintext = FileOperations.read(originalFilePath);
        String ciphertext = encryptionAlgorithm.encrypt(plaintext, key);
        if (isDoubleEncryption) {
            FileOperations.write(key.getKey1() + "." + key.getKey2(), keyPath);
        } else {
            FileOperations.write("" + key.getKey1(), keyPath);
        }
        FileOperations.write(ciphertext, outputPath);
        System.out.println("Location of encrypted file: " + outputPath);
        System.out.println("Location of encryption key: " + keyPath);
        notify(outputPath, 2);
    }

    public void decryptFile(String encryptedFilePath, String outputPath,
            String keyPath)
                    throws InvalidPathException, InvalidEncryptionKeyException {
        notify(encryptedFilePath, 3);
        String ciphertext = FileOperations.read(encryptedFilePath);
        System.out.println(ciphertext);
        Key key = keyParse(FileOperations.read(keyPath));
        String plaintext = encryptionAlgorithm.decrypt(ciphertext, key);
        FileOperations.write(plaintext, outputPath);
        System.out.println("Location of decrypted file: " + outputPath);
        notify(outputPath, 4);
    }

    public Key keyParse(String keyString) throws InvalidEncryptionKeyException {
        try {
            Key key;
            if (keyString.indexOf('.') != (-1)) {
                // if '.' occurs in keyString then this is a case of
                // DoubleEncryption.
                int key1 = Integer.parseInt(
                        keyString.substring(0, keyString.lastIndexOf('.')));
                int key2 = Integer.parseInt(keyString.substring(
                        keyString.lastIndexOf('.') + 1, keyString.length()));
                key = new Key(key1, key2);
            } else {// this is a case of non-double encryption.
                key = new Key(Integer.parseInt(keyString));
            }
            return key;
        } catch (NumberFormatException e) {
            throw new InvalidEncryptionKeyException();
        }
    }

    public File parseDir(String dirPath) throws InvalidPathException {
        try {
            if (Paths.get(dirPath).toFile().exists()) {
                return Paths.get(dirPath).toFile();
            } else
                throw new InvalidPathException(dirPath);
        } catch (java.nio.file.InvalidPathException e) {
            throw new InvalidPathException(dirPath);
        }
    }

    public void notify(String path, int type) {
        this.setChanged();
        this.notifyObservers(new EncryptionLogEventArgs(System.nanoTime(),
                this.encryptionAlgorithm, path, type));
    }
}
