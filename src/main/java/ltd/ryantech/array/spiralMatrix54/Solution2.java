package ltd.ryantech.array.spiralMatrix54;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.spiralMatrix54
 * @description
 * @create 2020/06/05 13:15
 **/

public class Solution2 {
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
        int tot = 1;
        ans.add(matrix[x][y]);
        visited[x][y] = 1;
        while (tot < resSize) {
            while (y + 1 < column && visited[x][y + 1] == 0) {
                visited[x][++y] = 1;
                ans.add(matrix[x][y]);
                tot++;
            }
            while (x + 1 < row && visited[x + 1][y] == 0) {
                visited[++x][y] = 1;
                ans.add(matrix[x][y]);
                tot++;
            }
            while (y - 1 >= 0 && visited[x][y - 1] == 0) {
                visited[x][--y] = 1;
                ans.add(matrix[x][y]);
                tot++;
            }
            while (x - 1 >= 0 && visited[x - 1][y] == 0) {
                visited[--x][y] = 1;
                ans.add(matrix[x][y]);
                tot++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] matrix = {};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> ans = new Solution2().spiralOrder(matrix);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
