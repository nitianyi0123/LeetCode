package leetcode.editor.cn;

//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 105 
// 
// 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 127 👎 0


public class MinimumDistanceBetweenBstNodes {

    public static void main(String[] args) {
	    Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int minDiffInBST(TreeNode root) {
        return distance(root).distance;
    }

    public NodeData distance(TreeNode node) {
        NodeData result = new NodeData(Integer.MAX_VALUE, node.val, node.val);
        if (node.left != null) {
            NodeData data = distance(node.left);
            int temp = Math.min(node.val - data.max, data.distance);
            result.distance = Math.min(temp, result.distance);
            result.min = data.min;
        }
        if (node.right != null) {
            NodeData data = distance(node.right);
            int temp = Math.min(data.min - node.val, data.distance);
            result.distance = Math.min(temp, result.distance);
            result.max = data.max;
        }
        return result;
    }

    private class NodeData {
        int distance;
        int min;
        int max;

        public NodeData(int distance, int min, int max) {
            this.distance = distance;
            this.min = min;
            this.max = max;
        }
    }
}


 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
         this.right = right;
     }
 }

//leetcode submit region end(Prohibit modification and deletion)


}