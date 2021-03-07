package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 604 👎 0


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
	    Solution solution = new PalindromePartitioning().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    private boolean[][] isPP;


    public List<List<String>> partition(String s) {
        int n = s.length();
        isPP = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isPP[i][j] = true;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                isPP[i][j] = isPP[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
        act(s, 0);
        return result;
    }

    public void act(String s, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPP[index][i]) {
                temp.add(s.substring(index, i + 1));
                act(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}