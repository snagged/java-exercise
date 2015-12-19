package com.javatraining1.encryptor1;

import java.util.concurrent.ThreadLocalRandom;

public class Key {
    private int key1;
    private int key2;
    private boolean isDoubleKey = false;

    public Key(int key1) {
        this.setKey1(key1);
    }

    public Key(int key1, int key2) {
        this.setKey1(key1);
        this.setKey2(key2);
        this.setDoubleKey(true);
    }

    public Key(boolean isDoubleKey) {
        if (isDoubleKey) {
            this.key1 = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            this.key2 = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            this.isDoubleKey = isDoubleKey;
        } else {
            this.key1 = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
        }
    }

    public boolean isDoubleKey() {
        return isDoubleKey;
    }

    public void setDoubleKey(boolean isDoubleKey) {
        this.isDoubleKey = isDoubleKey;
    }

    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

}
