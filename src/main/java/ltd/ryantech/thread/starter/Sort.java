package ltd.ryantech.thread.starter;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.thread.starter
 * @description
 * @create 2020/06/13 16:37
 **/

public class Sort {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(7);
        list.add(5);
        list.forEach(System.out::println);
        Collections.sort(list, (s1, s2) -> {
            if (s1 == null)
                return -1;
            if (s2 == null)
                return -1;
            return s2 - s1;
        });

        list.forEach(System.out::println);
        System.out.println(Collections.binarySearch(list, 10));
//        new Thread((int a,int b) -> {
//            int sum = a * b;
//            System.out.println(sum);
//        }).start();
        new Thread(
                () -> System.out.println("hello world")
        ).start();
    }
}
