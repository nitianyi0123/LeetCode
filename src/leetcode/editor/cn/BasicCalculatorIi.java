package leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 325 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorIi {

    public static void main(String[] args) {
	    Solution solution = new BasicCalculatorIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        char[] sChar = s.toCharArray();
        List<Object> sArr = new ArrayList<>();
        int i = 0;
        while (i < sChar.length) {
            if (sChar[i] < 48 || sChar[i] > 57) {
                if (sChar[i] == '+' || sChar[i] == '-'
                        || sChar[i] == '*' || sChar[i] == '/'
                        || sChar[i] == '(' || sChar[i] == ')') {
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
                    Character c = sign.pop();
                    if (c == '*' || c == '/') {
                        expression.add(c);
                        if (!sign.empty() && sign.peek() != '(') {
                            expression.add(sign.pop());
                        }
                    } else {
                        expression.add(c);
                    }
                }
                sign.push(value);
            } else if (value == '*' || value == '/') {
                if (!sign.empty() && sign.peek() != '(') {
                    if (sign.peek() == '*' || sign.peek() == '/') {
                        expression.add(sign.pop());
                    }
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

            } else if (value == '-') {
                if (result.size() > 1) {
                    result.push(-result.pop() + result.pop());
                } else {
                    result.push(-result.pop());
                }
            } else if (value == '*') {
                result.push(result.pop() * result.pop());
            } else {
                int minus = result.pop();
                int minused = result.pop();
                result.push(minused / minus);
            }
        }
        return result.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}