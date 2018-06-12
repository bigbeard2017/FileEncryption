package bigbeard.tools.file.encryption.entry;

import java.io.Serializable;

public class FileEncryInfo implements Serializable {
    private boolean isEncryption;
    private boolean enableHashCode;
    private char[] algorithmName = new char[150];
    private char[] originalFileHashCode = new char[64];


    public boolean isEnableHashCode() {
        return enableHashCode;
    }

    public void setEnableHashCode(boolean enableHashCode) {
        this.enableHashCode = enableHashCode;
    }

    public String getOriginalFileHashCode() {
        return new String(originalFileHashCode);
    }

    public void setOriginalFileHashCode(String originalFileHashCode) {
        char[] chars = originalFileHashCode.toCharArray();
        if (chars.length > this.originalFileHashCode.length) {
            throw new OutOfMemoryError("HashCode超过最大限度,当前最大限度为" + this.originalFileHashCode.length);
        } else {
            this.originalFileHashCode = chars;
        }
    }

    public String getAlgorithmName() {
        return new String(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        char[] chars = algorithmName.toCharArray();
        if (chars.length > this.algorithmName.length) {
            throw new OutOfMemoryError("算法名称超过最大限度,当前最大限度为" + this.algorithmName.length);
        } else {
            this.algorithmName = chars;
        }
    }

    public boolean isEncryption() {
        return isEncryption;
    }

    public void setEncryption(boolean encryption) {
        isEncryption = encryption;
    }
}
