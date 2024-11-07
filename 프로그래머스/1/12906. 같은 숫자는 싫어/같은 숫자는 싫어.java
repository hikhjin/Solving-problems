import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (dq.peekLast() == arr[i]) continue;
            dq.addLast(arr[i]);
        }
        
        int[] answer = new int[dq.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dq.pollFirst();
        }

        return answer;
    }
}