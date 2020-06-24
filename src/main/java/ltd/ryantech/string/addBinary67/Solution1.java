package ltd.ryantech.string.addBinary67;

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.string.addBinary67
 * @description 67. 二进制求和
 * @leetcode_CN_url // https://leetcode-cn.com/problems/add-binary/
 * @leetcode_US_url // https://leetcode.com/problems/add-binary/
 * @hard_level Easy
 * @tag String // https://leetcode-cn.com/tag/string/
 * @create 2020/06/23 13:50
 **/

public class Solution1 {
    public String addBinary(String a, String b) {
        // 竖式 模拟计算
        StringBuilder sb = new StringBuilder();
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            n1 = a.charAt(i) - '0';
            n2 = b.charAt(j) - '0';
            int t = (n1 + n2 + n3 > 1 ? (n1 + n2 + n3) % 2 : n1 + n2 + n3);
            n3 = (n1 + n2 + n3) / 2;
            sb.append(t);
            i--;
            j--;
        }
        // 处理剩余的字符
        while (i >= 0) {
            n1 = a.charAt(i) - '0';
            int t = (n1 + n3 > 1 ? (n1 + n3) % 2 : n1 + n3);
            n3 = (n1 + n3) / 2;
            sb.append(t);
            i--;
        }

        while (j >= 0) {
            n2 = b.charAt(j) - '0';
            int t = (n2 + n3 > 1 ? (n2 + n3) % 2 : n2 + n3);
            n3 = (n2 + n3) / 2;
            sb.append(t);
            j--;
        }
        // 最多还有最后一个 进位 需要处理
        if (n3 != 0) {
            sb.append(n3);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(new Solution1().addBinary(a, b));
    }
}
