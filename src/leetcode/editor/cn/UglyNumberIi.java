package leetcode.editor.cn;

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 539 👎 0


public class UglyNumberIi {

    public static void main(String[] args) {
	    Solution solution = new UglyNumberIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int[] temp = new int[3];
        for (int i = 1; i < n; i++) {
            int a = result[temp[0]] * 2;
            int b = result[temp[1]] * 3;
            int c = result[temp[2]] * 5;
            if (a < b) {
                if (a <= c) {
                    result[i] = a;
                    temp[0]++;
                }
                if (c <= a) {
                    result[i] = c;
                    temp[2]++;
                }
            } else if (b < a) {
                if (b <= c) {
                    result[i] = b;
                    temp[1]++;
                }
                if (c <= b) {
                    result[i] = c;
                    temp[2]++;
                }
            } else {
                if (b <= c) {
                    result[i] = b;
                    temp[0]++;
                    temp[1]++;
                }
                if (c <= b) {
                    result[i] = c;
                    temp[2]++;
                }
            }
        }
        return result[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}