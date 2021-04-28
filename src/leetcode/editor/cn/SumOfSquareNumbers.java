package leetcode.editor.cn;

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 223 👎 0


public class SumOfSquareNumbers {

    public static void main(String[] args) {
	    Solution solution = new SumOfSquareNumbers().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        int x = sqrt(c);
        for (int i = 0; i <= x; i++) {
            int temp = c - i * i;
            int result = sqrt(temp);
            if (result * result + i * i == c) {
                return true;
            }
        }
        return false;
    }

    public int sqrt(int c) {
        if (c <= 0) {
            return 0;
        }
        int x = c;
        while (true) {
            int temp = (x + c / x) / 2;
            if (temp >= x && temp - x <= 1) {
                return x;
            } else if (temp <= x && x - temp <= 1) {
                return temp;
            } else {
                x = temp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}