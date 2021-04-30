package leetcode.editor.cn;

//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 
// 👍 583 👎 0


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumberIi {

    public static void main(String[] args) {
	    Solution solution = new SingleNumberIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = result.get(nums[i]);
            if (value == null) {
                result.put(nums[i], 1);
            } else if (value == 1) {
                result.put(nums[i], 2);
            } else {
                result.remove(nums[i]);
            }
        }
        Iterator<Integer> iterator = result.keySet().iterator();
        return iterator.next();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}