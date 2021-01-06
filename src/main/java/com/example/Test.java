package com.example;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {

        System.out.println(valid("()"));
        System.out.println(valid(" {{()[]"));
    }

    private static boolean valid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
            }else{
                if (!stack.isEmpty()) {
                    char top = stack.peek();
                    if (top == '(' && cur == ')') {
                        stack.pop();
                    } else if (top == '[' && cur == ']') {
                        stack.pop();
                    } else if (top == '{' && cur == '}') {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
