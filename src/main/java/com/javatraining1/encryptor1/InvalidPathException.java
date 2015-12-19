package com.javatraining1.encryptor1;

import java.io.IOException;

public class InvalidPathException extends IOException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String errMsg = "";

    public InvalidPathException(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String getMessage() {
        return (errMsg);
    }
}
