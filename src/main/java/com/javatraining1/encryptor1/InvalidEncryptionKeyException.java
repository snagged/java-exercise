package com.javatraining1.encryptor1;

public class InvalidEncryptionKeyException extends NumberFormatException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return ("Key is not in correct format.");
    }
}
