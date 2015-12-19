package com.javatraining1.encryptor1;

import org.junit.Test;

public class RepeatEncryptionTest extends EncryptionAlgorithmTest {

    @Test
    public void repeat3ShiftUpEncryptionTest() {
        super.genericEncryptionAlgorithmTest();
    }

    @Test
    public void repeat3XorEncryptionTest() {
        super.setEA(new RepeatEncryption(new XorEncryption(), 3));
        super.genericEncryptionAlgorithmTest();
    }

    @Test
    public void repeat3ShiftMultiplyEncryptionTest() {
        super.setEA(new RepeatEncryption(new ShiftMultiplyEncryption(), 3));
        super.genericEncryptionAlgorithmTest();
    }

    @Test
    public void repeat5ShiftUpEncryptionTest() {
        super.setEA(new RepeatEncryption(new ShiftUpEncryption(), 5));
        super.genericEncryptionAlgorithmTest();
    }

    @Test
    public void repeat5DoubleXorEncryptionTest() {
        super.setEA(new RepeatEncryption(
                new DoubleEncryption(new XorEncryption()), 5));
        super.genericEncryptionAlgorithmTest();
    }

    @Test
    public void repeat5DoubleShiftUpEncryptionTest() {
        super.setEA(new RepeatEncryption(
                new DoubleEncryption(new ShiftUpEncryption()), 5));
        super.genericEncryptionAlgorithmTest();
    }

    @Test
    public void repeat3DoubleShiftMultiplyEncryptionTest() {
        super.setEA(new RepeatEncryption(
                new DoubleEncryption(new ShiftMultiplyEncryption()), 3));
        super.genericEncryptionAlgorithmTest();
    }

    public RepeatEncryptionTest() {
        super(new RepeatEncryption(new ShiftUpEncryption(), 3));
    }

}
