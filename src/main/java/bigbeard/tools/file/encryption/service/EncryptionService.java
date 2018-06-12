package bigbeard.tools.file.encryption.service;

import bigbeard.tools.file.encryption.DataCatch.Catch;
import bigbeard.tools.file.encryption.api.FileEncryAlgorithm;
import bigbeard.tools.file.encryption.entry.FileEntry;
import bigbeard.tools.file.encryption.service.imp.AlgorithmDES;
import bigbeard.tools.file.encryption.service.imp.CustomAlgorithmA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EncryptionService {

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

    public void addFileEntry(File file) {
        if (!file.exists()) {
            return;
        }
        FileEntry fileEntry = new FileEntry();
        fileEntry.setFilePath(file.getAbsolutePath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] filedata = new byte[100];
            int read = fileInputStream.read(filedata);
            if (read < filedata.length) {

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Catch.instance().AddFileEntry(fileEntry);
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
