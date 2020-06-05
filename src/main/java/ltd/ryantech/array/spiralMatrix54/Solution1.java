package ltd.ryantech.array.spiralMatrix54;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.spiralMatrix54
 * @description 54. 螺旋矩阵
 * @leetcode_CN_url // https://leetcode-cn.com/problems/spiral-matrix/
 * @leetcode_US_url // https://leetcode.com/problems/spiral-matrix/
 * @hard_level Medium
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/05 11:38
 **/

public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new LinkedList<>();
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int resSize = row * column;
        int[][] visited = new int[row][column];
        List<Integer> ans = new LinkedList<>();
        int x = 0;
        int y = 0;
        int tot = 0;
        while (tot < resSize) {
            while (y < column && visited[x][y] == 0) {
                visited[x][y] = 1;
                ans.add(matrix[x][y]);
                tot++;
                y++;
            }
            y--; // 修正
            x++; // 换到下一行
            while (x < row && visited[x][y] == 0) {
                visited[x][y] = 1;
                ans.add(matrix[x][y]);
                tot++;
                x++;
            }
            x--; // 修正
            y--; // 换行
            while (y >= 0 && visited[x][y] == 0) {
                visited[x][y] = 1;
                ans.add(matrix[x][y]);
                tot++;
                y--;
            }
            y++; // 修正
            x--; // 换行
            while (x >= 0 && visited[x][y] == 0) {
                visited[x][y] = 1;
                ans.add(matrix[x][y]);
                tot++;
                x--;
            }
            x++; // 修正
            y++; // 换行
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] matrix = {};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> ans = new Solution1().spiralOrder(matrix);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
