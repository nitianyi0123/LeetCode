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
        if (s.length() == 0) {
            return 0;
        }
        char[] sChar = s.toCharArray();
        int[] sCount = new int[sChar.length];
        char[] tChar = t.toCharArray();
        int[] tCount = new int[tChar.length];
        sCount[0] = 1;
        tCount[0] = 1;
        int sLen = 1;
        for (int i = 1; i < sChar.length; i++) {
            if (sChar[i] == sChar[sLen - 1]) {
                sCount[sLen - 1]++;
            } else {
                sLen++;
                sChar[sLen - 1] = sChar[i];
                sCount[sLen - 1] = 1;
            }
        }
        int tLen = 1;
        for (int i = 1; i < tChar.length; i++) {
            if (tChar[i] == tChar[tLen - 1]) {
                tCount[tLen - 1]++;
            } else {
                tLen++;
                tChar[tLen - 1] = tChar[i];
                tCount[tLen - 1] = 1;
            }
        }
        return count(sChar, tChar, sCount, tCount, 0, 0, sLen, tLen);
    }

    public int count(char[] s, char[] t, int[] sCount, int[] tCount, int sNum, int tIndex, int sLimit, int tLimit) {
        if (tIndex == tLimit) {
            return 1;
        }
        int result = 0;
        for (int i = sNum; i < sLimit; i++) {
            if (t[tIndex] == s[i]) {
                result += (calculate(sCount[i], tCount[tIndex]) *
                        count(s, t, sCount, tCount, i + 1, tIndex + 1, sLimit, tLimit));
            }
        }
        return result;
    }

    public int calculate(int x, int y) {
        int result1 = 1;
        int result2 = 1;
        for (int i = 0; i < y; i++) {
            result1 *= (x-i);
            result1 /= (i+1);
        }
        return result1 / result2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}