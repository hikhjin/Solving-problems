import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            // System.out.println(participant[i]);
            // System.out.println(completion[i]);
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[completion.length];
    }
}