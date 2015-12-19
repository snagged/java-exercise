package com.javatraining1.encryptor1;

import java.util.Comparator;

public class AlgorithmComparator implements Comparator<EncryptionAlgorithm> {
    // Note: this comparator imposes orderings that are inconsistent with
    // equals."
    @Override
    public int compare(EncryptionAlgorithm EncryptionAlgorithm1,
            EncryptionAlgorithm EncryptionAlgorithm2) {
        return EncryptionAlgorithm1.getKeyStrength()
                - EncryptionAlgorithm2.getKeyStrength();
    }

}
