package bigbeard.tools.file.encryption.service.imp;

import bigbeard.tools.file.encryption.api.FileEncryAlgorithm;

public class CustomAlgorithmA implements FileEncryAlgorithm {

    @Override
    public boolean decrypt(String sourceFilePath, String saveFilePath, String pwd) {
        return false;
    }

    @Override
    public boolean encrypt(String sourceFilePath, String saveFilePath, String pwd) {
        return false;
    }

    @Override
    public String getArithmenticName() {
        return "algorithmA";
    }
}
