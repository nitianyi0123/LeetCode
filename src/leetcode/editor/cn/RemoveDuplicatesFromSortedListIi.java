package leetcode.editor.cn;

//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 554 👎 0


public class RemoveDuplicatesFromSortedListIi {

    public static void main(String[] args) {
	    Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode leader = new ListNode();
        leader.next = head;
        boolean repeat = false;
        ListNode temp = null;
        ListNode node = leader;
        while (node.next != null) {
            if (temp != null && node.next.val == temp.val) {
                repeat = true;
                node.next =  node.next.next;
            } else {
                if (temp == null || repeat) {
                    repeat = false;
                    temp = node.next;
                    node.next =  node.next.next;
                } else {
                    ListNode nextTemp = node.next;
                    node.next = temp;
                    node.next.next = nextTemp.next;
                    temp = nextTemp;
                    node = node.next;
                }
            }
        }
        if (!repeat && temp != null) {
            node.next = temp;
            temp.next = null;
        }
        return leader.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}