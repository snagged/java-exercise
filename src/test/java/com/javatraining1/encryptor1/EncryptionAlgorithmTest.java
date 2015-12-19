package com.javatraining1.encryptor1;

import static org.junit.Assert.*;

public class EncryptionAlgorithmTest {

    private EncryptionAlgorithm EncryptionAlgorithm;

    public void genericEncryptionAlgorithmTest() {
        /*
         * assertEquals("Testing intensifies",
         * EncryptionAlgorithm.decrypt(EncryptionAlgorithm.encrypt(
         * "Testing intensifies", new Key(42)), new Key(42)));
         */
        Key key = new Key(true);
        assertEquals("Testing intensifies", EncryptionAlgorithm.decrypt(
                EncryptionAlgorithm.encrypt("Testing intensifies", key), key));
    }

    public EncryptionAlgorithmTest(EncryptionAlgorithm EA) {
        this.EncryptionAlgorithm = EA;
    }

    public void setEA(EncryptionAlgorithm EA) {
        this.EncryptionAlgorithm = EA;
    }

}
