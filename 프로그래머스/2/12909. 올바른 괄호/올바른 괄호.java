import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
                else stack.push(s.charAt(i));
            }
            else stack.push(s.charAt(i));
        }
        
        if (!stack.isEmpty()) return false;
        return true;
    }
}