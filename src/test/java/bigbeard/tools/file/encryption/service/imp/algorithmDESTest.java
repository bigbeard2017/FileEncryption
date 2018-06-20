package bigbeard.tools.file.encryption.service.imp;

import bigbeard.tools.file.encryption.api.FileEncryAlgorithm;
import org.junit.Test;

public class algorithmDESTest {


    private static String unEncryPath = "/home/bigbeard/workall/work/greatech/Docs/CodeDocs/DatabaseDesign_2/码表定义.txt";
    private static String encryPath = "/home/bigbeard/workall/work/greatech/Docs/CodeDocs/DatabaseDesign_2/yjm码表定义.txt";
    private FileEncryAlgorithm algorithmDES = new AlgorithmDES();

    private String pwd = "123456";

    @Test
    public void decrypt() {
        boolean decrypt = algorithmDES.decrypt(encryPath, unEncryPath + "11", pwd);
        System.out.println(decrypt);
    }

    @Test
    public void encrypt() {
        boolean encrypt = algorithmDES.encrypt(unEncryPath, encryPath, pwd);
        System.out.println(encrypt);
    }
}