package bigbeard.tools.file.encryption.service.imp;

import bigbeard.tools.file.encryption.api.FileEncryAlgorithm;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

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

    @Test
    public void test() {
        byte[] chars = null;
        try {
            chars = "abcd".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] bb = new byte[100];
        System.arraycopy(chars, 0, bb, 0, chars.length);
        try {
            String s = new String(bb, "UTF-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}