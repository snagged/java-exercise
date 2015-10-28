package com.javatraining1.encryptor1;

import org.junit.Test;

public class XorEncryptionTest extends EncryptionAlgorithmTest {

    @Test
    public void test() {
        super.test();
    }

    public XorEncryptionTest() {
        super(new XorEncryption());
    }

}
