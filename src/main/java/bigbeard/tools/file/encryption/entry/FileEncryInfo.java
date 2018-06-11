package bigbeard.tools.file.encryption.entry;

import java.io.Serializable;

public class FileEncryInfo implements Serializable {
    private boolean isEncryption;
    private boolean enableHashCode;
    private String algorithmName;
    private String originalFileHashCode;


    public boolean isEnableHashCode() {
        return enableHashCode;
    }

    public void setEnableHashCode(boolean enableHashCode) {
        this.enableHashCode = enableHashCode;
    }

    public String getOriginalFileHashCode() {
        return originalFileHashCode;
    }

    public void setOriginalFileHashCode(String originalFileHashCode) {
        this.originalFileHashCode = originalFileHashCode;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public boolean isEncryption() {
        return isEncryption;
    }

    public void setEncryption(boolean encryption) {
        isEncryption = encryption;
    }
}
