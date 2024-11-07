import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>(); // 다리 위 트럭
        int sec = 1;
        int idx = 1;
        int sum = truck_weights[0];
        queue.offer(new Truck(truck_weights[0], 1));
        
        while (!queue.isEmpty()) {
            if (queue.peek().pos == bridge_length) {
                sum -= queue.poll().w;
            }
            
            if (idx < truck_weights.length) {
                if (sum + truck_weights[idx] <= weight) {
                    sum += truck_weights[idx];
                    queue.offer(new Truck(truck_weights[idx], 0));
                    idx++;
                }
            }
            
            for (Truck t : queue) {
                t.pos++;
            }
            sec++;
        }
        
        return sec;
    }
}

class Truck {
    int w;
    int pos;
    
    public Truck(int w, int pos) {
        this.w = w;
        this.pos = pos;
    }
}