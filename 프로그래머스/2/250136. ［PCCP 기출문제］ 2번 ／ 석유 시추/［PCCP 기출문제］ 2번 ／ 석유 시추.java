import java.util.*;

class Solution {
    static int n, m;
    static int[] oil;
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        n = land.length; // 세로
        //System.out.println(n);
        m = land[0].length; // 가로
        //System.out.println(m);
        visited = new boolean[n][m];
        oil = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(land, i, j);
                }
            }
        }
        
        Arrays.sort(oil);
        return oil[m-1];
    }
    
    static void bfs(int[][] land, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            set.add(cur[1]);
            cnt++;
            
            for (int[] dir : dirs) {
                int nx = dir[0] + cur[0];
                int ny = dir[1] + cur[1];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        for (int s : set) {
            oil[s] += cnt;
        }
    }
}