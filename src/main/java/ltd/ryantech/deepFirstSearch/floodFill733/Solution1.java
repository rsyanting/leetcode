package ltd.ryantech.deepFirstSearch.floodFill733;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.deepFirstSearch.floodFill733
 * @description 图像渲染
 * @leetcode_CN_url // https://leetcode-cn.com/problems/flood-fill/
 * @leetcode_US_url // https://leetcode.com/problems/flood-fill/
 * @hard_level Easy
 * @tag Depth First Search
 * @create 2020/05/11 15:40
 **/

public class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], visited, newColor);
        return image;
    }

    public void dfs(int[][] image, int row, int column, int origin, boolean[][] visited, int newColor) {
        // dfs 的方向为 上 下 左 右
        if (row < 0 || row >= image.length ||
                column < 0 || column >= image[0].length ||
                visited[row][column] ||
                image[row][column] != origin) {
            return;
        }
        image[row][column] = newColor;
        visited[row][column] = true;
        dfs(image, row - 1, column, origin, visited, newColor);
        dfs(image, row + 1, column, origin, visited, newColor);
        dfs(image, row, column - 1, origin, visited, newColor);
        dfs(image, row, column + 1, origin, visited, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        image = new Solution1().floodFill(image, 1, 1, 1);
        for (int[] ints : image) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
