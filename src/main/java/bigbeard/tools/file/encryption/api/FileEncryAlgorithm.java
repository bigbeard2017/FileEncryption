package bigbeard.tools.file.encryption.api;


public interface FileEncryAlgorithm {
    /**
     * 解密
     *
     * @param sourceFilePath 需要解密的文件
     * @param saveFilePath   解密后保存路径
     * @param pwd            密码
     * @return true解密成功, 否则失败
     */
    boolean decrypt(String sourceFilePath, String saveFilePath, String pwd);

    /**
     * 加密
     *
     * @param sourceFilePath 需要加密的文件
     * @param saveFilePath   加密后存放路径
     * @param pwd            密码
     * @return true解密成功, 否则失败
     */
    boolean encrypt(String sourceFilePath, String saveFilePath, String pwd);

    /**
     * 当前算法名称,需要注意名称不要重复
     *
     * @return 返回算法名称
     */
    String getArithmenticName();
}
