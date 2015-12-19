package com.javatraining1.encryptor1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncDirectoryProcessor implements DirectoryProcessor {
    private FileEncryptor fileEncryptor;

    public AsyncDirectoryProcessor(FileEncryptor fileEncryptor) {
        this.fileEncryptor = fileEncryptor;
    }

    public void encryptDirectory(String dirPath)
            throws InvalidPathException, InterruptedException {
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
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<Void>> tasks = new ArrayList<Callable<Void>>();
        for (File file : listOfFiles) {
            FileEncryptor tmpFileEncryptor = new FileEncryptor(fileEncryptor);
            EncryptFileRunnable runnable = new EncryptFileRunnable(
                    file.getPath(),
                    folder_encrypted.getPath() + "\\" + file.getName(),
                    folder_encrypted.getPath() + "\\key.txt", key,
                    tmpFileEncryptor);
            tasks.add(runnable);
        }
        executorService.invokeAll(tasks);
        fileEncryptor.notify(folder_encrypted.getPath(), 6);
    }

    public void decryptDirectory(String dirPath)
            throws InvalidPathException, InterruptedException {
        File folder = fileEncryptor.parseDir(dirPath);
        System.out.println(folder.toString());
        System.out.println("derp");
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return (fileName.endsWith(".txt")
                        && !fileName.startsWith("key"));
            }
        });
        File folder_decrypted = new File(folder.getPath() + "\\decrypted");
        folder_decrypted.mkdir();
        fileEncryptor.notify(folder.getPath(), 7);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<Void>> tasks = new ArrayList<Callable<Void>>();
        for (File file : listOfFiles) {
            FileEncryptor tmpFileEncryptor = new FileEncryptor(fileEncryptor);
            DecryptFileRunnable runnable = new DecryptFileRunnable(
                    file.getPath(),
                    folder_decrypted.getPath() + "\\" + file.getName(),
                    folder.getPath() + "\\key.txt", tmpFileEncryptor);
            tasks.add(runnable);
        }
        executorService.invokeAll(tasks);
        fileEncryptor.notify(folder_decrypted.getPath(), 8);
    }
}
