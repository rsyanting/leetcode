package ltd.ryantech.stack.minStack155;

import java.util.Stack;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.stack.minStack155
 * @description 155. 最小栈
 * @leetcode_CN_url // https://leetcode-cn.com/problems/min-stack/
 * @hard_level Easy
 * @tag Stack // https://leetcode-cn.com/tag/stack/
 * @create 2020/06/16 13:21
 **/

public class MinStack {

    /**
     * initialize your data structure here.
     */

    private Stack<Integer> stackValue;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackValue = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int x) {
        if (this.stackValue.isEmpty() || this.stackMin.peek() >= x) {
            this.stackMin.push(x);
        }
        this.stackValue.push(x);
    }

    public void pop() {
        if (this.stackValue.peek().equals(this.stackMin.peek())) {
            this.stackMin.pop();
        }
        this.stackValue.pop();
    }

    public int top() {
        return this.stackValue.peek();
    }

    public int getMin() {
        return this.stackMin.peek();
    }
}
