import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            // 전선 끊기
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            
            boolean[] visited = new boolean[n+1];
            int cnt1 = bfs(graph, wire[0], visited);
            int cnt2 = n - cnt1;
            
            min = Math.min(min, Math.abs(cnt1-cnt2));
            
            // 다시 복구
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        return min;
    }
    
    static int bfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }
}