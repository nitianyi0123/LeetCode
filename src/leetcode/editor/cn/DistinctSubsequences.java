package leetcode.editor.cn;

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 410 👎 0


public class DistinctSubsequences {

    public static void main(String[] args) {
	    Solution solution = new DistinctSubsequences().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[][] result = new int[sChar.length+1][tChar.length+1];
        for (int i = sChar.length; i >= 0; i--) {
            for (int j = tChar.length; j >= 0; j--) {
                if (sChar.length - i < tChar.length - j) {
                    result[i][j] = 0;
                    continue;
                }
                if (j == tChar.length) {
                    result[i][j] = 1;
                    continue;
                }
                if (sChar[i] == tChar[j]) {
                    result[i][j] = result[i+1][j+1] + result[i+1][j];
                } else {
                    result[i][j] = result[i+1][j];
                }
            }
        }
        return result[0][0];

    }


}
//leetcode submit region end(Prohibit modification and deletion)


}