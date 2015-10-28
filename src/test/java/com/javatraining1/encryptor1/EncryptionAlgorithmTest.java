package com.javatraining1.encryptor1;

import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

public class EncryptionAlgorithmTest {

    private EncryptionAlgorithm EA;

    public void test() {
        assertEquals("Testing intensifies",
                EA.decrypt(EA.encrypt("Testing intensifies", 42), 42));
        int key = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
        assertEquals("Testing intensifies",
                EA.decrypt(EA.encrypt("Testing intensifies", key), key));
    }

    public EncryptionAlgorithmTest(EncryptionAlgorithm EA) {
        this.EA = EA;
    }

    public void setEA(EncryptionAlgorithm EA) {
        this.EA = EA;
    }

}
