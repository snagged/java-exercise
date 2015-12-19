package com.javatraining1.encryptor1;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ExceptionTest {

    public void genericKeyTest(String key, boolean isBadKey)
            throws URISyntaxException, InvalidPathException {
        URL resourceUrl = getClass().getResource(key);
        URL resourceUrl2 = getClass().getResource("/CipherTextFile.txt");
        URL resourceUrl3 = getClass().getResource("/PlaintextFile.txt");
        Path keyPath = Paths.get(resourceUrl.toURI());
        Path pathToCipher = Paths.get(resourceUrl2.toURI());
        Path pathToPlaintext = Paths.get(resourceUrl3.toURI());
        try {
            FileEncryptor FileEncryptor = new FileEncryptor(
                    new DoubleEncryption(new ShiftUpEncryption()));
            FileEncryptor.decryptFile(pathToCipher.toString(),
                    pathToPlaintext.toString(), keyPath.toString());
        } catch (InvalidEncryptionKeyException e) {
            assertTrue(isBadKey);
            return;
        }
        assertTrue(!isBadKey);
    }

    @Test
    public void BadKeyTest1() throws URISyntaxException, InvalidPathException {
        genericKeyTest("/BadKeyFile.txt", true);
    }

    @Test
    public void BadKeyTest2() throws URISyntaxException, InvalidPathException {
        genericKeyTest("/BadKeyFile2.txt", true);
    }

    @Test
    public void BadKeyTest3() throws URISyntaxException, InvalidPathException {
        genericKeyTest("/BadKeyFile3.txt", true);
    }

    @Test
    public void GoodKeyTest1() throws URISyntaxException, InvalidPathException {
        genericKeyTest("/GoodKeyFile.txt", false);
    }

    @Test
    public void GoodKeyTest2() throws URISyntaxException, InvalidPathException {
        genericKeyTest("/GoodKeyFile2.txt", false);
    }
}
