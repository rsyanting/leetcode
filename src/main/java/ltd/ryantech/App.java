package ltd.ryantech;

import java.io.IOException;

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

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(new App().isUnique(s1));
    }
}
