package ltd.ryantech.heap.findKthLargest215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.heap.findKthLargest215
 * @description
 * @create 2020/06/18 11:27
 **/

public class Main {
    public Main() {
        this.stackValue = new LinkedList<>();
        this.stackMin = new LinkedList<>();
    }

    Deque<Integer> stackValue;
    Deque<Integer> stackMin;

    public void push(int node) {
        if (stackValue.isEmpty() || stackMin.peekLast() >= node) {
            stackMin.offerLast(node);
        }
        stackValue.offerLast(node);
    }

    public int pop() {
        if (stackValue.isEmpty()) {
            return 0;
        }

        if (stackValue.peekLast().equals(stackMin.peekLast())) {
            stackMin.pollLast();
        }
        int t = stackValue.peekLast();
        stackValue.pollLast();
        return t;
    }

    public int min() {
        if (stackMin.isEmpty()) {
            return 0;
        }
        return stackMin.peekLast();
    }

    public static void main(String[] args) throws IOException {
        Main mainInstance = new Main();
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int caseNum = (int) st.nval;
        StringBuilder sb = new StringBuilder(caseNum * 4);
        while (caseNum-- > 0) {
            st.nextToken();
            int caseFlag = (int) st.nval;
            if (caseFlag == 0) {
                sb.append(mainInstance.min()).append('\n');
            }
            if (caseFlag == 1) {
                st.nextToken();
                int caseArgs = (int) st.nval;
                mainInstance.push(caseArgs);
            }
            if (caseFlag == 2) {
                sb.append(mainInstance.pop()).append('\n');
            }
        }
        System.out.println(sb.toString().trim());
    }
}
