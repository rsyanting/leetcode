package ltd.ryantech.greedy.twoCityScheduling1029;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.greedy.twoCityScheduling1029
 * @description 两地调度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/two-city-scheduling/
 * @leetcode_US_url // https://leetcode.com/problems/two-city-scheduling/
 * @hard_level Easy
 * @tag Greedy // https://leetcode-cn.com/tag/greedy/
 * @create 2020/06/03 17:59
 **/

public class Solution1 {
    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        int length = costs.length;
        for (int i = 0; i < length; i++) {
            minCost += costs[i][0];
            // costs[i][1] 为选择去 B 城市，节省的费用
            costs[i][1] = costs[i][1] - costs[i][0];
        }
        Queue<Integer> queue = new PriorityQueue<>();
        int idx = 0;
        while (idx < length) {
            queue.offer(costs[idx][1]);
            idx++;
        }
        // 优先队列前 N 个为去 B 节约的花费
        for (int i = 0; i < length / 2; i++) {
            minCost += queue.remove();
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(new Solution1().twoCitySchedCost(costs));
    }
}
