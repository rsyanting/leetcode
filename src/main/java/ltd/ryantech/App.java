package ltd.ryantech;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) - 1);
        return ~num & mask;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.findComplement(5));
    }
}
