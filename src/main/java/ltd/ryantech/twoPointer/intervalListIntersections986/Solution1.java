package ltd.ryantech.twoPointer.intervalListIntersections986;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.twoPointer.intervalListIntersections986
 * @description 区间列表的交集
 * @leetcode_CN_url // https://leetcode-cn.com/problems/interval-list-intersections/comments/
 * @leetcode_US_url // https://leetcode.com/problems/interval-list-intersections/comments/
 * @hard_level Medium
 * @tag Two Pointer // https://leetcode-cn.com/tag/two-pointers/
 * @create 2020/05/23 16:34
 **/

public class Solution1 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        int begin = 0;   // 交集开始位置
        int end = 0;     // 交集结束位置
        List<int[]> res = new LinkedList<>();
        while (i < A.length && j < B.length) {
            // 内部 if 判断是核心
            if (A[i][1] < B[j][0]) {
                i++;
            } else if (A[i][0] > B[j][1]) {
                j++;
            } else {
                begin = Math.max(A[i][0], B[j][0]);
                end = Math.min(A[i][1], B[j][1]);
                res.add(new int[]{begin, end});
                // A 区间结束比 B 早，A 向后移动一个位置
                if (A[i][1] <= B[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        int resSize = res.size();
        int[][] resArray = new int[resSize][2];
        for (int index = 0; index < resSize; index++) {
            resArray[index] = res.remove(0);    // 每次移除链表头部即可
        }
        return resArray;
    }

    public static void main(String[] args) {
//        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
//        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] A = {{3, 10}};
        int[][] B = {{5, 10}};

        int[][] res = new Solution1().intervalIntersection(A, B);
        for (int[] r : res) {
            for (int i : r) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
