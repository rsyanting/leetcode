package ltd.ryantech.thread.pwdMd5;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.thread.pwdMd5
 * @description
 * @create 2020/06/13 13:53
 **/

public class RandomString {

    final static String alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom secureRandom = new SecureRandom();

    public static String getRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            stringBuilder.append(alphaNumeric.charAt(secureRandom.nextInt(alphaNumeric.length())));
        return stringBuilder.toString();
    }
}
