package ltd.ryantech.stack.onlineStockSpan901;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.onlineStockSpan901
 * @description 901. 股票价格跨度
 * @leetcode_CN_url // https://leetcode-cn.com/problems/online-stock-span/
 * @hard_level Medium
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/10/13 21:35
 **/

public class StockSpanner {
    Deque<Integer> indexes;
    Deque<Integer> prices;

    public StockSpanner() {
        this.indexes = new LinkedList<>();
        this.prices = new LinkedList<>();
    }

    public int next(int price) {
        int ans = 1;
        while (!this.prices.isEmpty() && this.prices.peekLast() <= price) {
            this.prices.pollLast();
            ans += this.indexes.isEmpty() ? 0 : this.indexes.pollLast(); // 实际上这里不会出现加 0 的情况
        }
        this.indexes.offerLast(ans);
        this.prices.offerLast(price);
        return ans;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
