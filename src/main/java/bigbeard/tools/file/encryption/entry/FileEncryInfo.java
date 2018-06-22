package bigbeard.tools.file.encryption.entry;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import static bigbeard.tools.file.encryption.util.ConstValue.*;

public class FileEncryInfo implements Serializable {

    private boolean isEncryption = false;
    private boolean enableHashCode = false;
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
        byte[] chars = new byte[0];
        try {
            chars = originalFileHashCode.getBytes(ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (chars.length > START_HASH_CODE_LEN) {
            throw new OutOfMemoryError("HashCode超过最大限度,当前最大限度为" + START_HASH_CODE_LEN);
        } else {
            this.originalFileHashCode = originalFileHashCode;
        }
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        //char[] chars = algorithmName.toCharArray();
        byte[] asciis = null;
        try {
            asciis = algorithmName.getBytes(ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (asciis.length > START_ALGORITHM_NAME_LEN) {
            throw new OutOfMemoryError("算法名称超过最大限度,当前最大限度为" + START_ALGORITHM_NAME_LEN);
        } else {
            this.algorithmName = algorithmName;
        }
    }

    public boolean isEncryption() {
        return isEncryption;
    }

    public void setEncryption(boolean encryption) {
        isEncryption = encryption;
    }

    public byte[] getAlgorithmNameByte() {
        try {
            return this.algorithmName.getBytes(ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] getOriginalFileHashCodeByte() {
        try {
            return this.originalFileHashCode.getBytes(ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
