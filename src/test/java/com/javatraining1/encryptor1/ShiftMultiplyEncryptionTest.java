package com.javatraining1.encryptor1;

import org.junit.Test;

public class ShiftMultiplyEncryptionTest extends EncryptionAlgorithmTest {

    @Test
    public void genericEncryptionAlgorithmTest() {
        super.genericEncryptionAlgorithmTest();
    }

    public ShiftMultiplyEncryptionTest() {
        super(new ShiftMultiplyEncryption());
    }

}
