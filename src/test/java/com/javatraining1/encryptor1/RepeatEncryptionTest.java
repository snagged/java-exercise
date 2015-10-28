package com.javatraining1.encryptor1;

import org.junit.Test;

public class RepeatEncryptionTest extends EncryptionAlgorithmTest {

    @Test
    public void test() {
        super.test();
        super.setEA(new RepeatEncryption(new XorEncryption(), 3));
        super.test();
        super.setEA(new RepeatEncryption(new ShiftMultiplyEncryption(), 3));
        super.test();
        super.setEA(new RepeatEncryption(new ShiftUpEncryption(), 5));
        super.test();
        super.setEA(new RepeatEncryption(
                new DoubleEncryption(new XorEncryption()), 5));
        super.test();
        super.setEA(new RepeatEncryption(
                new DoubleEncryption(new ShiftUpEncryption()), 5));
        super.test();
        super.setEA(new RepeatEncryption(
                new DoubleEncryption(new ShiftMultiplyEncryption()), 3));
        super.test();
    }

    public RepeatEncryptionTest() {
        super(new RepeatEncryption(new ShiftUpEncryption(), 3));
    }

}
