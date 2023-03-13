package org.parenthesis;

import java.util.Stack;

public class Solution {
    private String testString = "()[]{}";
    private String testString1 = "(()())[[][()({}{{}})]]{((()))[[[[]]]]{{{{{{{{{{{}}}}}}}}}}}}";
    private String testString2 = "]((()})[)";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid(solution.testString1));
    }
    public boolean isValid(String s) {
        char[] parenthesis = s.toCharArray();
        Stack<Character> stackOfParenthesis = new Stack<>();
        for (int i = 0; i < parenthesis.length; i++) {
            char current = parenthesis[i];
            if (current == '(' || current == '{' || current == '[') {
                stackOfParenthesis.push(current);
            } else {
                //closing parenthesis, lets see if last one matches
                if (stackOfParenthesis.isEmpty()) {
                    return false;
                }
                char last = stackOfParenthesis.pop();
                if ((current == '}' && last !='{') ||
                        (current == ')' && last !='(') ||
                        (current == ']' && last !='[')) {
                    return false;
                }
            }
        }
        if(!stackOfParenthesis.isEmpty()) {
            return false;
        }
        return true;
    }
}
