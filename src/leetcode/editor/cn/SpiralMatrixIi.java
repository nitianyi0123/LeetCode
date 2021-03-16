package leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 365 👎 0


public class SpiralMatrixIi {

    public static void main(String[] args) {
	    Solution solution = new SpiralMatrixIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowIndex = 0;
        int colIndex = 0;
        int rowStartLimit = 0;
        int rowEndLimit = n;
        int colStartLimit = 0;
        int colEndLimit = n;
        int num = 1;
        int count = 0;
        while (rowStartLimit < rowEndLimit && colStartLimit < colEndLimit) {
            result[rowIndex][colIndex] = num;
            num++;
            if (count % 4 == 0) {
                if (colIndex == colEndLimit - 1) {
                    rowStartLimit++;
                    count++;
                    rowIndex++;
                } else {
                    colIndex++;
                }
            } else if (count % 4 == 1) {
                if (rowIndex == rowEndLimit - 1) {
                    colEndLimit--;
                    count++;
                    colIndex--;
                } else {
                    rowIndex++;
                }
            } else if (count % 4 == 2) {
                if (colIndex == colStartLimit) {
                    rowEndLimit--;
                    count++;
                    rowIndex--;
                } else {
                    colIndex--;
                }
            } else {
                if (rowIndex == rowStartLimit) {
                    colStartLimit++;
                    count++;
                    colIndex++;
                } else {
                    rowIndex--;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}