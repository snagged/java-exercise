package com.javatraining1.encryptor1;

import java.util.Observable;
import java.util.Observer;

public class EncryptionLogger implements Observer {
    private String currFile;
    private long startTime;
    private String currDir;
    private long dirStartTime;

    @Override
    public void update(Observable o, Object arg) {
        EncryptionLogEventArgs args = (EncryptionLogEventArgs) arg;
        if (args.getEventType() == 1 || args.getEventType() == 3) {
            // 1=encryption started, 3=decryption started
            this.currFile = args.getFilePath();
            this.startTime = args.getTime();
        }
        if (args.getEventType() == 5 || args.getEventType() == 7) {
            // 5=folder encryption started, 7=folder decryption started
            this.currDir = args.getFilePath();
            this.dirStartTime = args.getTime();
        }
        if (args.getEventType() == 2) {// 2=file encryption ended
            System.out.println("The encryption for file " + this.currFile
                    + " with algorithm "
                    + args.getEncryptionAlgorithm().getName() + " took "
                    + (args.getTime() - this.startTime)
                    + " nanoseconds. The encrypted file is located in "
                    + args.getFilePath());
        }
        if (args.getEventType() == 4) {// 4=file decryption ended
            System.out.println("The decryption for file " + this.currFile
                    + " with algorithm "
                    + args.getEncryptionAlgorithm().getName() + " took "
                    + (args.getTime() - this.startTime)
                    + " nanoseconds. The decrypted file is located in "
                    + args.getFilePath());
        }
        if (args.getEventType() == 6) {// folder encryption ended
            System.out.println("The encryption for folder " + this.currDir
                    + " with algorithm "
                    + args.getEncryptionAlgorithm().getName() + " took "
                    + (args.getTime() - this.dirStartTime)
                    + " nanoseconds. The encrypted files are located in "
                    + args.getFilePath());
        }
        if (args.getEventType() == 8) {// folder decryption ended
            System.out.println("The decryption for folder " + this.currDir
                    + " with algorithm "
                    + args.getEncryptionAlgorithm().getName() + " took "
                    + (args.getTime() - this.dirStartTime)
                    + " nanoseconds. The decrypted files are located in "
                    + args.getFilePath());
        }
    }
}
