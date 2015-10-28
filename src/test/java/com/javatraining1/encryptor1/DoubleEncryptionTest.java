package com.javatraining1.encryptor1;

import org.junit.Test;

public class DoubleEncryptionTest extends EncryptionAlgorithmTest {

    @Test
    public void test() {
        super.test();
        super.setEA(new DoubleEncryption(new ShiftMultiplyEncryption()));
        super.test();
        super.setEA(new DoubleEncryption(new XorEncryption()));
        super.test();
        super.setEA(new DoubleEncryption(new ShiftUpEncryption()));
        super.test();
        super.setEA(new DoubleEncryption(
                new RepeatEncryption(new XorEncryption(), 3)));
        super.test();
        super.setEA(new DoubleEncryption(
                new RepeatEncryption(new ShiftUpEncryption(), 3)));
        super.test();
        super.setEA(new DoubleEncryption(
                new RepeatEncryption(new ShiftMultiplyEncryption(), 3)));
        super.test();
    }

    public DoubleEncryptionTest() {
        super(new DoubleEncryption(new ShiftUpEncryption()));
    }

}
