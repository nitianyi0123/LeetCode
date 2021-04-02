package leetcode.editor.cn;

//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 151 👎 0


public class VolumeOfHistogramLcci {

    public static void main(String[] args) {
	    Solution solution = new VolumeOfHistogramLcci().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int[] leftMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }
        int[] rightMax = new int[height.length];
        for (int i = height.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            int value = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (value > 0) {
                result += value;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}