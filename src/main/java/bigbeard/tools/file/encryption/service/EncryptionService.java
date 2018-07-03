package bigbeard.tools.file.encryption.service;

import bigbeard.tools.file.encryption.DataCatch.Catch;
import bigbeard.tools.file.encryption.api.FileEncryAlgorithm;
import bigbeard.tools.file.encryption.entry.FileEncryInfo;
import bigbeard.tools.file.encryption.entry.FileEntry;
import bigbeard.tools.file.encryption.service.imp.AlgorithmDES;
import bigbeard.tools.file.encryption.service.imp.CustomAlgorithmA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bigbeard.tools.file.encryption.util.ConstValue.*;

public class EncryptionService {

    private static final int START_ALL_LEN = START_HEAD_LEN
            + START_IS_ENTCRY_LEN
            + START_IS_HASH_CODE_LEN
            + START_ALGORITHM_NAME_LEN
            + START_HASH_CODE_LEN;

    private Map<String, FileEncryAlgorithm> algorithmHashMap = new HashMap<>();

    private EncryptionService() {
    }

    public static EncryptionService instance() {
        return Singleton.INSTANCE.getInstance();
    }

    /**
     * 初始化系统中的算法
     */
    public void initAlgorithm() {
        FileEncryAlgorithm algorithmDES = new AlgorithmDES();
        algorithmHashMap.put(algorithmDES.getArithmenticName(), algorithmDES);
        FileEncryAlgorithm customAlgorithmA = new CustomAlgorithmA();
        algorithmHashMap.put(customAlgorithmA.getArithmenticName(), customAlgorithmA);
    }

    /**
     * 获取所有算法
     *
     * @return 当前系统支持的加解密算法
     */
    public Map<String, FileEncryAlgorithm> getAlgorithmInfos() {
        if (algorithmHashMap.size() == 0) {
            initAlgorithm();
        }
        return algorithmHashMap;
    }


    public void addFileEntry(String absolutePath) {
        File f = new File(absolutePath);
        addFileEntry(f);
    }

    public void clear() {
        Catch.instance().clear();
    }

    public void addFileEntry(File file) {
        if (!file.exists()) {
            return;
        }
        FileEntry fileEntry = new FileEntry();
        FileEncryInfo fileEncryInfo = new FileEncryInfo();
        fileEntry.setFileEncryInfo(fileEncryInfo);
        fileEntry.setFilePath(file.getAbsolutePath());

        fileEntry.setSelected(false);

        String fileName = file.getName();
        int i = fileName.lastIndexOf(".");

        if (i + 1 < file.length()) {
            String suffix = fileName.substring(i + 1);
            fileEntry.setFileExtendName(suffix);
        } else {
            fileEntry.setFileExtendName("");
        }
        fileEntry.setFileName(fileName);
        fileEntry.setFileSize(String.valueOf(String.format("%.2f", file.length() / 1024f)));

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] filedata = new byte[START_ALL_LEN];
            int readCount = fileInputStream.read(filedata);
            if (readCount == filedata.length) {
                Integer headValue = byteArrayToInt(filedata, 0);
                if (headValue == START_HEAD_FLAG) {
                    if (filedata[START_HEAD_LEN] == IS_TRUE_VALUE) {
                        fileEncryInfo.setEncryption(true);
                    }
                    if (filedata[START_HEAD_LEN + START_IS_ENTCRY_LEN] == IS_TRUE_VALUE) {
                        fileEncryInfo.setEnableHashCode(true);
                    }
                    int start = START_HEAD_LEN + START_IS_ENTCRY_LEN + START_IS_HASH_CODE_LEN;
                    int len = 0;
                    for (int ix = 0; ix < START_ALGORITHM_NAME_LEN; ix++) {
                        if (filedata[start + ix] != 0) {
                            len++;
                        } else {
                            break;
                        }
                    }
                    byte[] bytes = new byte[len];
                    System.arraycopy(filedata, start, bytes, 0, len);
                    fileEncryInfo.setAlgorithmName(new String(bytes, ENCODE));
                    start = START_ALL_LEN - START_HASH_CODE_LEN;
                    len = 0;
                    for (int ix = 0; ix < START_HASH_CODE_LEN; ix++) {
                        if (filedata[start + ix] != 0) {
                            len++;
                        } else {
                            break;
                        }
                    }
                    bytes = new byte[len];
                    fileEncryInfo.setOriginalFileHashCode(new String(bytes, ENCODE));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Catch.instance().AddFileEntry(fileEntry);
    }

    public List<FileEntry> getAllFileEntry() {
        return Catch.instance().getFileEntries();
    }

    private byte[] intToByteArray(int value) {
        byte[] bytes = new byte[4];
        bytes[4] = (byte) (value & 0xFF);
        bytes[4 + 1] = (byte) ((value >> 8) & 0xFF);
        bytes[4 + 2] = (byte) ((value >> 16) & 0xFF);
        bytes[4 + 3] = (byte) ((value >> 24) & 0xFF);
        return bytes;
    }

    private Integer byteArrayToInt(byte[] bytes, int start) {
        if (bytes.length < (start + 4)) {
            return null;
        }
        int intValue = (bytes[start + 0] & 0xff)
                | (((bytes[start + 1] & 0xff) << 8))
                | (((bytes[start + 2] & 0xff) << 16))
                | ((bytes[start + 3] & 0xff) << 24);
        return intValue;
    }

    private enum Singleton {
        INSTANCE;
        private EncryptionService singleton;

        Singleton() {
            singleton = new EncryptionService();
        }

        public EncryptionService getInstance() {
            return singleton;
        }
    }
}
