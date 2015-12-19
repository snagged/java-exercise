package com.javatraining1.encryptor1;

public class EncryptionLogEventArgs {
    private long time;
    private EncryptionAlgorithm encryptionAlgorithm;
    private String filePath;
    private int eventType;

    public EncryptionLogEventArgs(long time,
            EncryptionAlgorithm encryptionAlgorithm, String filePath,
            int eventType) {
        this.time = time;
        this.encryptionAlgorithm = encryptionAlgorithm;
        this.filePath = filePath;
        this.eventType = eventType;
    }

    public long getTime() {
        return this.time;
    }

    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getEventType() {
        return eventType;
    }

    public boolean equals(Object arg) {
        if (arg == null) {
            return false;
        }
        if (!(arg instanceof EncryptionLogEventArgs)) {
            return false;
        }
        EncryptionLogEventArgs other = (EncryptionLogEventArgs) arg;
        if (getEncryptionAlgorithm() != other.getEncryptionAlgorithm()) {
            return false;
        }
        if (getEventType() != other.getEventType()) {
            return false;
        }
        if (getFilePath() != other.getFilePath()) {
            return false;
        }
        if (getTime() != other.getTime()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (encryptionAlgorithm.getName() != null
                ? encryptionAlgorithm.getName().hashCode() : 0);
        hash = 89 * hash + (int) (getTime() ^ (getTime() >>> 32));
        hash = 89 * hash
                + (getFilePath() != null ? getFilePath().hashCode() : 0);
        hash = 89 * hash + getEventType();
        return hash;
    }
}
