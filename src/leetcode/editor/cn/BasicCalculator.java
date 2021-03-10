package leetcode.editor.cn;

//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 447 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
	    Solution solution = new BasicCalculator().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        char[] sChar = s.toCharArray();
        List<Object> sArr = new ArrayList<>();
        int i = 0;
        while (i < sChar.length) {
            if (sChar[i] < 48 || sChar[i] > 57) {
                if (sChar[i] == '+' || sChar[i] == '-' || sChar[i] == '(' || sChar[i] == ')') {
                    sArr.add(sChar[i]);
                }
                i++;
                continue;
            }
            int temp = 0;
            while (i < sChar.length && sChar[i] >= 48 && sChar[i] <= 57) {
                temp = temp * 10 + sChar[i] - 48;
                i++;
            }
            sArr.add(temp);
        }
        Stack<Character> sign = new Stack<>();
        List<Object> expression = new ArrayList<>();
        for (int j = 0; j < sArr.size(); j++) {
            Object ele = sArr.get(j);
            if (ele instanceof Integer) {
                expression.add(ele);
                continue;
            }
            char value = (Character) ele;
            if (value == '(') {
                sign.push(value);
            } else if (value == '+' || value == '-') {
                if (!sign.empty() && sign.peek() != '(') {
                    expression.add(sign.pop());
                }
                sign.push(value);
            } else {
                while (true) {
                    if (sign.empty()) {
                        break;
                    }
                    Character temp = sign.pop();
                    if (temp == '(') {
                        break;
                    }
                    expression.add(temp);
                }
            }
        }
        while (!sign.empty()) {
            expression.add(sign.pop());
        }
        Stack<Integer> result = new Stack<>();
        for (int j = 0; j < expression.size(); j++) {
            Object ele = expression.get(j);
            if (ele instanceof Number) {
                result.push((Integer) ele);
                continue;
            }
            char value = (Character) ele;
            if (value == '+') {
                if (result.size() > 1) {
                    result.push(result.pop() + result.pop());
                } else {
                    result.push(result.pop());
                }

            } else {
                if (result.size() > 1) {
                    result.push(-result.pop() + result.pop());
                } else {
                    result.push(-result.pop());
                }
            }
        }
        return result.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}