package com.javatraining1.encryptor1;

public interface DirectoryProcessor {
    public void encryptDirectory(String dirPath)
            throws InvalidPathException, InterruptedException;

    public void decryptDirectory(String dirPath)
            throws InvalidPathException, InterruptedException;
}
