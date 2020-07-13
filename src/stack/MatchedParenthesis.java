package stack;

import java.util.Stack;

/*
Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.

Example:

    Input: exp = "[()]{}{[()()]()}"
    Output: Balanced

    Input: exp = "[(])"
    Output: Not Balanced

Solution:If we found an open bracket we push it in stack,When we find an close bracket, we pop the stack and compare it with the array element, if it is not a match return false.
Otherwise repeat the process.
let input is Input: exp = "[(])".First two character is open parens , so push it in stack.The 3rd one is close close bracket , so pop the stack and compare.It is not a match, so return false.
|      |
|      |
|      |
|______|
|___{__|
|___[__|
* */
public class MatchedParenthesis {
    public static boolean findIfParenthesesIsMatched(String parens) {
        String openParens = "({[";
        Stack<Character> stack = new Stack<>();
        char[] chars = parens.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (openParens.contains(String.valueOf(chars[i]))) {
                stack.push(chars[i]);
            } else {
                if (!stack.isEmpty()) {
                    Character peek = stack.pop();
                    if (chars[i] == ')' && peek != '(') {
                        return false;
                    }
                    if (chars[i] == '}' && peek != '{') {
                        return false;
                    }
                    if (chars[i] == '[' && peek != ']') {
                        return false;
                    }
                }
                else{
                    return false;
                }
                }
            }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(findIfParenthesesIsMatched("[()]{}{[()()]()}"));
        System.out.println(findIfParenthesesIsMatched(")}]"));
        System.out.println(findIfParenthesesIsMatched("{()}[]"));
        System.out.println(findIfParenthesesIsMatched("{{{{}{}(})"));
    }
}

