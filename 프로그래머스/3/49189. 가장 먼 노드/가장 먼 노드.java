import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean visited[] = new boolean[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int answer = BFS(n, visited, graph);
        return answer;
    }
    
    static int BFS(int n, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0; 
        int depth = 0;
        
        queue.add(new int[] {1, 0});
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int vertex = poll[0]; // 현재 간선
            int tmp = poll[1]; // 얼마나 떨어져 있는지
            
            if (depth == tmp) {
                cnt++;
            } else if (depth < tmp) {
                cnt = 1;
                depth = tmp;
            }
            
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int w = graph.get(vertex).get(i); // 인접한 접점
                
                if(!visited[w]) {
                    queue.add(new int[] {w, tmp + 1});
                    visited[w] = true;
                }
            }
        }
         return cnt;
    }
}