package com.leetcode.exercise.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Valid {

    public static boolean isValid(String s) {
        Map map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (map.containsKey(s.charAt(i))) {
                if (stack.empty()){
                    return false;
                }
                Character pop = stack.pop();
                if (!pop.equals(map.get(s.charAt(i)))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]{}"));
        System.out.println(isValid("[]{{}"));
        System.out.println(isValid("[}"));
        System.out.println(isValid("[()]"));
        System.out.println(isValid("(("));
    }
}
