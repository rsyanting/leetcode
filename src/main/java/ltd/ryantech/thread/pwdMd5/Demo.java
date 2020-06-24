package ltd.ryantech.thread.pwdMd5;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.thread.pwdMd5
 * @description
 * @create 2020/06/13 13:13
 **/

public class Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plainText = "123";

        String sha1String = DigestUtils.sha1Hex("password");
        System.out.println(sha1String);

        String string = RandomString.getRandomString(20);
//        randomString.nextString();
        System.out.println(string);

        String md5String = DigestUtils.md5Hex(plainText.getBytes(StandardCharsets.UTF_8));
        System.out.println(md5String);

//        System.out.println(UUID.randomUUID().toString());

//        String string = RandomString.getRandomString(15);
////        randomString.nextString();
//        System.out.println(string);

    }
}
