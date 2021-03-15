package leetcode.editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 714 👎 0


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
	    Solution solution = new SpiralMatrix().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int count = 0;
        int rowStartLimit = 0;
        int rowEndLimit = matrix.length - 1;
        int columnStartLimit = 0;
        int columnEndLimit = matrix[0].length - 1;
        int rowIndex = 0;
        int columnIndex = 0;
        while (rowStartLimit <= rowEndLimit && columnStartLimit <= columnEndLimit) {
            result.add(matrix[rowIndex][columnIndex]);
            int flag = count % 4;
            if (flag == 0) {
                columnIndex++;
            } else if (flag == 1) {
                rowIndex++;
            } else if (flag == 2) {
                columnIndex--;
            } else {
                rowIndex--;
            }
            if (rowIndex < rowStartLimit) {
                rowIndex = rowStartLimit;
                columnIndex++;
                columnStartLimit++;
                count++;
            } else if (rowIndex > rowEndLimit) {
                rowIndex = rowEndLimit;
                columnIndex--;
                columnEndLimit--;
                count++;
            } else if (columnIndex < columnStartLimit) {
                columnIndex = columnStartLimit;
                rowIndex--;
                rowEndLimit--;
                count++;
            } else if (columnIndex > columnEndLimit) {
                columnIndex = columnEndLimit;
                rowIndex++;
                rowStartLimit++;
                count++;
            }
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}