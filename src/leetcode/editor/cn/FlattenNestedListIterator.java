package leetcode.editor.cn;

//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 281 👎 0


import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

    public static void main(String[] args) {
	    Solution solution = new FlattenNestedListIterator().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<NestedInteger> nestedList;
    private int cursor;
    private NestedIterator nestedIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        NestedInteger data = nestedList.get(cursor);
        if (data.isInteger()) {
            cursor++;
            return data.getInteger();
        } else {
            return nestedIterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (nestedList == null || cursor >= nestedList.size()) {
            return false;
        }
        while (cursor < nestedList.size()) {
            NestedInteger data = nestedList.get(cursor);
            if (data == null) {
                cursor++;
                continue;
            }
            if (data.isInteger()) {
                return true;
            } else {
                if (nestedIterator == null) {
                    nestedIterator = new NestedIterator(data.getList());
                }
                if (nestedIterator.hasNext()) {
                    return true;
                } else {
                    nestedIterator = null;
                    cursor++;
                }
            }
        }
        return false;
    }

}

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

class Solution {

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)


}