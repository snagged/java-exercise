package com.javatraining1.encryptor1;

import java.io.File;
import java.io.FilenameFilter;

public class SyncDirectoryProcessor implements DirectoryProcessor {
    private FileEncryptor fileEncryptor;

    public SyncDirectoryProcessor(FileEncryptor fileEncryptor) {
        this.fileEncryptor = fileEncryptor;
    }

    public void encryptDirectory(String dirPath) throws InvalidPathException {
        File folder = fileEncryptor.parseDir(dirPath);
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".txt");
            }
        });
        File folder_encrypted = new File(folder.getPath() + "\\encrypted");
        folder_encrypted.mkdir();
        fileEncryptor.notify(folder.getPath(), 5);
        Key key = new Key(fileEncryptor.isDoubleEncryption());
        for (File file : listOfFiles) {
            fileEncryptor.encryptFile(file.getPath(),
                    folder_encrypted.getPath() + "\\" + file.getName(),
                    folder_encrypted.getPath() + "\\key.txt", key);
        }
        fileEncryptor.notify(folder_encrypted.getPath(), 6);
    }

    public void decryptDirectory(String dirPath)
            throws InvalidPathException, InvalidEncryptionKeyException {
        File folder = fileEncryptor.parseDir(dirPath);
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return (fileName.endsWith(".txt")
                        && !fileName.startsWith("key"));
            }
        });
        File folder_decrypted = new File(folder.getPath() + "\\decrypted");
        folder_decrypted.mkdir();
        fileEncryptor.notify(folder.getPath(), 7);
        for (File file : listOfFiles) {
            fileEncryptor.decryptFile(file.getPath(),
                    folder_decrypted.getPath() + "\\" + file.getName(),
                    folder.getPath() + "\\key.txt");
        }
        fileEncryptor.notify(folder_decrypted.getPath(), 8);
    }
}
