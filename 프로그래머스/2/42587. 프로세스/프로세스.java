import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int n : priorities) {
            pq.offer(n);
        }
        
        int cnt = 0;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    cnt++;
                    if (location == i) return cnt;
                }
            }
        }
        return 0;
    }
}