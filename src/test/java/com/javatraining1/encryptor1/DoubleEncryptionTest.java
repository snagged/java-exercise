package com.javatraining1.encryptor1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DoubleEncryptionTest {

    private DoubleEncryption DoubleEncryption;

    @Test
    public void genericDoubleEncryptionTest() {
        assertEquals("Testing intensifies",
                DoubleEncryption.decrypt(DoubleEncryption
                        .encrypt("Testing intensifies", new Key(42, 84)),
                new Key(42, 84)));
        Key key = new Key(true);
        assertEquals("Testing intensifies", DoubleEncryption.decrypt(
                DoubleEncryption.encrypt("Testing intensifies", key), key));
    }

    @Test
    public void doubleShiftMultiplyEncryptionTest() {
        setEncryptionAlgorithm(new ShiftMultiplyEncryption());
        genericDoubleEncryptionTest();
    }

    @Test
    public void doubleXorEncryptionTest() {
        setEncryptionAlgorithm(new XorEncryption());
        genericDoubleEncryptionTest();
    }

    @Test
    public void doubleShiftUpEncryptionTest() {
        setEncryptionAlgorithm(new ShiftUpEncryption());
        genericDoubleEncryptionTest();
    }

    @Test
    public void doubleRepeatXorEncryptionTest() {
        setEncryptionAlgorithm(new RepeatEncryption(new XorEncryption(), 3));
        genericDoubleEncryptionTest();
    }

    @Test
    public void doubleRepeatShiftUpEncryptionTest() {
        setEncryptionAlgorithm(
                new RepeatEncryption(new ShiftUpEncryption(), 3));
        genericDoubleEncryptionTest();
    }

    @Test
    public void doubleRepeatShiftMultiplyEncryptionTest() {
        setEncryptionAlgorithm(
                new RepeatEncryption(new ShiftMultiplyEncryption(), 3));
        genericDoubleEncryptionTest();
    }

    public void setEncryptionAlgorithm(
            EncryptionAlgorithm EncryptionAlgorithm) {
        this.DoubleEncryption = new DoubleEncryption(EncryptionAlgorithm);
    }

    public DoubleEncryptionTest() {
        this.DoubleEncryption = new DoubleEncryption(new ShiftUpEncryption());
    }

}
