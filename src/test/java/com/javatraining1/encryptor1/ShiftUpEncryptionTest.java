package com.javatraining1.encryptor1;

import org.junit.Test;

public class ShiftUpEncryptionTest extends EncryptionAlgorithmTest {

    @Test
    public void genericEncryptionAlgorithmTest() {
        super.genericEncryptionAlgorithmTest();
    }

    public ShiftUpEncryptionTest() {
        super(new ShiftUpEncryption());
    }

}
