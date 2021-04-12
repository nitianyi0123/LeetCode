package leetcode.editor.cn;

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 625 👎 0


import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
	    Solution solution = new LargestNumber().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (compare(nums[j-1], nums[j]) < 0) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public int compare(int x, int y) {
        if (x == y) {
            return 0;
        }
        long xNum = 10;
        while (x >= xNum) {
            xNum *= 10;
        }
        long yNum = 10;
        while (y >= yNum) {
            yNum *= 10;
        }
        if ((x * yNum + y) > (y * xNum + x)) {
            return 1;
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}