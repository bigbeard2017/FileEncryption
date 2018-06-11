package bigbeard.tools.file.encryption.service.imp;

import bigbeard.tools.file.encryption.api.FileEncryAlgorithm;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.Key;
import java.security.SecureRandom;

public class AlgorithmDES implements FileEncryAlgorithm {

    private static final String ARITHMENTIC = "DES";

    @Override
    public boolean decrypt(String sourceFilePath, String saveFilePath, String pwd) {
        try {
            File file = new File(sourceFilePath);
            if (!file.exists()) {
                throw new FileNotFoundException("文件不存在:" + sourceFilePath);
            }
            SecureRandom random = new SecureRandom();
            Cipher cipher = Cipher.getInstance(ARITHMENTIC);
            Key secretKey = getSecretKey(pwd);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
            InputStream is = new FileInputStream(sourceFilePath);
            OutputStream out = new FileOutputStream(saveFilePath);
            CipherOutputStream cos = new CipherOutputStream(out, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = is.read(buffer)) >= 0) {
                cos.write(buffer, 0, r);
            }
            cos.close();
            out.close();
            is.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private Key getSecretKey(String pwd) throws Exception {
        if (null == pwd || "".equals(pwd)) {
            throw new Exception("pass word is not allow null or empty");
        }
        int i = pwd.length() % 8;
        if (i != 0) {
            String f = "%0" + (8 - i) + "d";
            pwd += String.format(f, 0);
        }
        DESKeySpec desKey = new DESKeySpec(pwd.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ARITHMENTIC);
        SecretKey securekey = keyFactory.generateSecret(desKey);
        return securekey;
    }

    @Override
    public boolean encrypt(String sourceFilePath, String saveFilePath, String pwd) {
        try {
            File file = new File(sourceFilePath);
            if (!file.exists()) {
                throw new FileNotFoundException("文件不存在:" + sourceFilePath);
            }
            SecureRandom random = new SecureRandom();
            Cipher cipher = Cipher.getInstance(ARITHMENTIC);
            Key secretKey = getSecretKey(pwd);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, random);
            InputStream is = new FileInputStream(sourceFilePath);
            OutputStream out = new FileOutputStream(saveFilePath);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
            cis.close();
            is.close();
            out.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public String getArithmenticName() {
        return ARITHMENTIC;
    }

}
