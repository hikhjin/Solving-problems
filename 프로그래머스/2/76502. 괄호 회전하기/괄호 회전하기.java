import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack;
        
        for (int i = 0; i < s.length(); i++) {
            stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        char t = stack.peek();
                        if ((t == '(' && c == ')') || (t == '[' && c == ']') || (t == '{' && c == '}')) {
                            stack.pop();
                        }
                        
                    } else {
                        answer--;
                        break;
                    }
                }
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
            
            s = s.substring(1, s.length()) + s.substring(0, 1); // 회전
        }
        return answer;
    }
}