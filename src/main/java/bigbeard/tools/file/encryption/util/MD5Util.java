package bigbeard.tools.file.encryption.util;

import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 */
public class MD5Util {

    private static final String BEGIN_STRING = "bigbeardEncryption";

    /**
     * 16进制字典数组
     */
    private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 获取code的MD5值
     *
     * @param code 需要编码的字符串
     * @return MD5值
     */
    public static String MD5(String code) {

        /* 用于加密的字符 */
        char md5String[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            code = BEGIN_STRING + code;
            byte[] btInput = code.getBytes();
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {   //  i = 0
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5
                str[k++] = md5String[byte0 & 0xf];   //   F
            }
            //返回经过加密后的字符串
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取文件的MD5码
     *
     * @param realPath 目标文件
     * @return md5字符串
     * @throws IOException IO异常
     */
    public static String FileMD5String(String realPath) throws IOException {
        File file = new File(realPath);
        if (!file.exists()) return "";
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        String md5 = MD5(channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length()));
        channel.close();
        fileInputStream.close();
        return md5;
    }

    /**
     * 获取文件的MD5码
     *
     * @param channel 文件管道
     * @return md5字符串
     * @throws IOException IO异常
     */
    public static String FileMD5String(FileChannel channel) throws IOException {
        String md5 = MD5(channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()));
        channel.close();
        return md5;
    }

    /**
     * 获取字符串的SHA码
     *
     * @param str 目标字符串
     * @return SHA字符串
     */
    public static String StringSHAString(String str) {
        return SHA(str.getBytes());

    }

    /**
     * 获取字符串的MD5码
     *
     * @param str 目标字符串
     * @return md5字符串
     */
    public static String StringMD5String(String str) {
        return MD5(str.getBytes());

    }

    private static String MD5(ByteBuffer byteBuffer) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            //清除映射 关闭资源
            Cleaner var1 = ((DirectBuffer) byteBuffer).cleaner();
            if (var1 != null) {
                var1.clean();
            }
            return byteToHex(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String MD5(byte[] bytes) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(bytes, 0, bytes.length);
            return byteToHex(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String SHA(byte[] bytes) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA");
            sha.update(bytes, 0, bytes.length);
            return byteToHex(sha.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String byteToHex(byte bytes[]) {
        return byteToHex(bytes, 0, bytes.length);
    }

    private static String byteToHex(byte bytes[], int m, int n) {
        StringBuilder stringBuffer = new StringBuilder(n * 2);
        int k = m + n;
        for (int i = 0; i < k; i++) {
            //转换为16进制
            //坑 (bt & 0xf0) >>> 4 和 bt & 0xf0 >>> 4 执行顺序问题  移位操作优先于与操作!!!!!!!!!!!!!
            char c0 = hexDigits[(bytes[i] & 0xf0) >>> 4]; //获取该8位中的高4位 并转换成16进制字符 >>>无符号为右移
            char c1 = hexDigits[bytes[i] & 0xf];//获取该8位中的底4位 并转换成16进制字符
            stringBuffer.append(c0);
            stringBuffer.append(c1);
        }
        return stringBuffer.toString();
    }
}
