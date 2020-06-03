package ltd.ryantech.graph.findTheTownJudge997;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.graph.findTheTownJudge997
 * @description 997. 找到小镇的法官
 * @leetcode_CN_url // https://leetcode-cn.com/problems/find-the-town-judge/
 * @leetcode_US_url // https://leetcode.com/problems/find-the-town-judge/
 * @hard_level Easy
 * @tag Graph // https://leetcode-cn.com/tag/graph/
 * @create 2020/06/03 13:20
 **/

public class Solution2 {
    public int findJudge(int N, int[][] trust) {
        int[] counter = new int[N + 1];
        for (int[] idx : trust) {
            counter[idx[0]]--; // 出度
            counter[idx[1]]++; // 入度
        }
        for (int i = 1; i <= N; i++) {
            // 法官的 入度 - 出度 等于 N - 1
            // 其中出度为 0
            if (counter[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(new Solution2().findJudge(N, trust));
    }
}
