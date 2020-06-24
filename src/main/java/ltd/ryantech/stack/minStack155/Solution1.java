package ltd.ryantech.stack.minStack155;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.minStack155
 * @description 155. 最小栈
 * @leetcode_CN_url // https://leetcode-cn.com/problems/min-stack/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/06/16 13:23
 **/

public class Solution1 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
