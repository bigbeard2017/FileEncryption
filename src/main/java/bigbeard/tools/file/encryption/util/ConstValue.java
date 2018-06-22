package bigbeard.tools.file.encryption.util;

/**
 * Created by bigbeard on 2018/6/22.
 */
public class ConstValue {
    public static final int START_HEAD_FLAG = 0xfdcea;
    public static final byte IS_TRUE_VALUE = 1;

    public static final int START_HEAD_LEN = 4;
    public static final int START_IS_ENTCRY_LEN = 1;
    public static final int START_IS_HASH_CODE_LEN = 1;
    public static final int START_ALGORITHM_NAME_LEN = 150;
    public static final int START_HASH_CODE_LEN = 64;

    public static final String ENCODE = "UTF-8";
}
