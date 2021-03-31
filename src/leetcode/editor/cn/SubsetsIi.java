package leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 515 👎 0


import java.util.*;

public class SubsetsIi {

    public static void main(String[] args) {
	    Solution solution = new SubsetsIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> distinctNum = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            countMap.put(nums[i], count == null ? 1 : (count+1));
        }
        for (Integer key : countMap.keySet()) {
            distinctNum.add(key);
        }
        result.add(new ArrayList<>());
        subsets(new Integer[]{}, countMap, 0);
        return result;
    }

    public void subsets(Integer[] chosen, Map<Integer, Integer> countMap, int index) {
        if (index == distinctNum.size()) {
            return;
        }
        for (int j = index; j < distinctNum.size(); j++) {
            int num = distinctNum.get(j);
            int count = countMap.get(num);
            while (count > 0) {
                Integer[] temp = Arrays.copyOf(chosen, chosen.length+count);
                for (int i = 0; i < count; i++) {
                    temp[chosen.length+i] = num;
                }
                result.add(Arrays.asList(temp));
                count--;
                subsets(temp, countMap, j+1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}