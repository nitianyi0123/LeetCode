package leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 393 👎 0


public class SearchA2dMatrix {

    public static void main(String[] args) {
	    Solution solution = new SearchA2dMatrix().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int startRow = 0;
        int endRow = matrix.length - 1;
        while (startRow < endRow) {
            int temp = (startRow + endRow) / 2;
            if (matrix[temp].length == 0) {
                return false;
            }
            if (target < matrix[temp][0]) {
                endRow = temp;
            } else {
                startRow = temp + 1;
            }
        }
        if (startRow > 0 && target < matrix[startRow][0]) {
            startRow--;
        }
        int startCol = 0;
        int endCol = matrix[startRow].length - 1;
        while (startCol < endCol) {
            int temp = (startCol + endCol) / 2;
            if (target < matrix[startRow][temp]) {
                endCol = temp;
            } else if (target > matrix[startRow][temp]) {
                startCol = temp + 1;
            } else {
                return true;
            }
        }
        return matrix[startRow][startCol] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}