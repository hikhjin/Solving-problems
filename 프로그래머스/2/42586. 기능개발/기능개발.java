import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int tmp = 100 - progresses[i];
            if (tmp % speeds[i] == 0) queue.offer(tmp/speeds[i]);
            else queue.offer(tmp/speeds[i] + 1);
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                list.add(1);
                break;
            }
            int now = queue.poll();
            int status = 1;
            // System.out.println("now: " + now);
            // if (queue.isEmpty()) {
            //     list.add(status);
            //     System.out.println("s: " + status);
            //     break;
            // }
            while (!queue.isEmpty()) {
                if (now >= queue.peek()) {
                // System.out.println("peek: " + queue.peek());
                queue.poll();
                status++;
                if (queue.isEmpty()) list.add(status);
                } else {
                    list.add(status);
                    break;
                }
            }
            
            // System.out.println(status);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}