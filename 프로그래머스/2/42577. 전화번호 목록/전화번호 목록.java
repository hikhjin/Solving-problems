import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for (String s : phone_book) {
            set.add(s);
        }
        
        for (String num : phone_book) {
            for (int i = 1; i < num.length(); i++) {
                String tmp = num.substring(0, i);
                if (set.contains(tmp)) return false;
            }
        }
        return answer;
    }
}