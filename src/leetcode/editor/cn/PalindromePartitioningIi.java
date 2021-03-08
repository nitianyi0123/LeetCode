package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 370 👎 0


import java.util.Arrays;

public class PalindromePartitioningIi {

    public static void main(String[] args) {
	    Solution solution = new PalindromePartitioningIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] isPP = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                isPP[i][j] = true;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                isPP[i][j] = isPP[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
        int[] result = new int[len];
        Arrays.fill(result, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (isPP[0][i]) {
                result[i] = 0;
            } else {
                for (int j = i; j > 0; j--) {
                    if (isPP[j][i]) {
                        result[i] = Math.min(result[i], result[j - 1] + 1);
                    }
                }
            }
        }
        return result[len-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}