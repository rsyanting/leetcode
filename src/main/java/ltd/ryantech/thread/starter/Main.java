package ltd.ryantech.thread.starter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.thread.starter
 * @description
 * @create 2020/07/04 12:47
 **/

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        int index = input.nextInt();
        int u = input.nextInt();
        int v = input.nextInt();

        Deque<int[]> uList = new LinkedList<>();
        Deque<int[]> vList = new LinkedList<>();
        for (int i = 0; i < u; i++) {
            int[] t = new int[2];
            t[0] = input.nextInt();
            t[1] = input.nextInt();
            uList.offerLast(t);
        }

        for (int i = 0; i < v; i++) {
            int[] t = new int[2];
            t[0] = input.nextInt();
            t[1] = input.nextInt();
            vList.offerLast(t);
        }

        long sum = 0;
        int u_p = 0;
        int v_p = 0;
        while (!uList.isEmpty() && !vList.isEmpty()) {
            u_p = uList.peekFirst()[0];
            v_p = vList.peekFirst()[0];

            while (u_p < v_p && !uList.isEmpty()) {
                uList.pollFirst();
            }

            if (u_p == v_p) {
                int u_val = uList.pollFirst()[1];
                int v_val = vList.pollFirst()[1];
                sum += u_val * v_val;
//				System.out.println(u_val  + " : " + v_val);
            }

            while (u_p > v_p && !vList.isEmpty()) {
                vList.pollFirst();
            }

            if (u_p == v_p) {
                int u_val = uList.pollFirst()[1];
                int v_val = vList.pollFirst()[1];
                sum += u_val * v_val;
//				System.out.println(u_val  + " : " + v_val);
            }
        }

//		for (int i = 0;i < index;i++) {
//			u_p = uList.peekFirst()[0];
//			v_p = vList.peekFirst()[0];
//			if (u_p == v_p) {
//				sum += uList.pollFirst()[1] * vList.pollFirst()[1];
//			}
//			if (u_p < v_p) {
//				uList.pollFirst();
//			} else {
//				vList.pollFirst();
//			}
//		}

        System.out.println(sum);

//		System.out.println(Long.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE);

        input.close();

    } // end of main

} // end of Main


// 10 3 4 4 -7 5 -6 2 7 3 5 4 -10 5 -7 6 9 8 10
