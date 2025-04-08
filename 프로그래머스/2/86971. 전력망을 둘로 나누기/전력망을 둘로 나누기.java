import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] wire: wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            
            boolean[] visited = new boolean[n+1];
            int cnt1 = bfs(graph, wire[0], visited);
            int cnt2 = n - cnt1;
            
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
            
            ans = Math.min(Math.abs(cnt1-cnt2), ans);
            
        }
        return ans;
    }
    
    static int bfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}