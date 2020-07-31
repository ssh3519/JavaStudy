package com.ssh.suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class KuoHaoPiPei {
    public static void main(String[] args) {

        System.out.println(isMatch("(***)-[{-------}]")); //true
        System.out.println(isMatch("(2+4)*a[5]")); //true
        System.out.println(isMatch("({}[]]])")); //false
        System.out.println(isMatch("())))")); //false
    }

    private static boolean isMatch(String s) {
        Map<Character,Character> bracket = new HashMap<>();
        bracket.put(')','(');
        bracket.put(']','[');
        bracket.put('}','{');

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (bracket.containsValue(c)){
                stack.push(c);
            }else if (bracket.containsKey(c)){
                if (stack.empty()){
                    return false;
                }
                if (stack.peek()==bracket.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
