import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static Stack<Integer> stack = new Stack<>();
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String s = maps[i];
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'X') {
                    map[i][j] = 0;
                } else map[i][j] = s.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        
        if (stack.isEmpty()) return new int[]{-1};
        
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pop();
        }
        Arrays.sort(ans);
        return ans;
    }
    
     static void bfs(int x, int y) {
        System.out.println("---------------");
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        visited[x][y] = true;
        queue.offer(new int[]{x,y});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            cnt += map[cur[0]][cur[1]];
            System.out.println("map:" + map[cur[0]][cur[1]]);
            System.out.println("cnt: " + cnt);
            
            for (int[] dir : dirs) {
                int nx = dir[0] + cur[0];
                int ny = dir[1] + cur[1];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] != 0) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        stack.push(cnt);
    }
}