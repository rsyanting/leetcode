package ltd.ryantech;

import javafx.util.Pair;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public boolean isUnique(String astr) {
        int bitmask = 0;
        for (char c : astr.toCharArray()) {
            bitmask = bitmask ^ c;
            if (bitmask == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String s1 = "leetcode";
        System.out.println(new App().isUnique(s1));
    }
}
