package com.wbtang.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * MD5工具类
 *
 * @author TangWenBo
 * @date 2019/12/25
 */
public class Md5Utils {
    /**
     * 加盐
     */
    private static final String SALT = "~!@#$%^&*()TWB";


    private static String getMD5(byte[] bytes) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] str = new char[32];

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] tmp = md.digest();
            int k = 0;
            int size = 16;
            for (int i = 0; i < size; ++i) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return new String(str);
    }

    /**
     * 对字符串进行加密
     *
     * @param value 字符串
     * @return java.lang.String
     * @author TangWenBo
     * @date 2019/12/25 16:15
     */
    public static String getMD5(String value) {
        return getMD5(value.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 自定义加盐算法
     *
     * @param value 字符串
     * @return java.lang.String
     * @author TangWenBo
     * @date 2019/12/25 16:19
     */
    public static String getMD5WithSalt(String value) {
        return getMD5((value + SALT).getBytes(StandardCharsets.UTF_8));
    }
}
