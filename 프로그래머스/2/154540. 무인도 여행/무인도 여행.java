import java.util.*;

class Solution {
    static int[][] arr;
    static Stack<Integer> stack = new Stack<>();
    static boolean[][] visited;
    static int row, col;
    
    public int[] solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        System.out.println("row: " + row + " col: " + col);
        arr = new int[row][col];
        visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) { // arr에 지도 정보 저장
            String s = maps[i];
            for (int j = 0; j < col; j++) {
                if (s.charAt(j) == 'X') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = s.charAt(j)-'0';
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    System.out.println(i + " " + j + " " + arr[i][j]);
                    bfs(i, j);
                } 
            }
        }
        
        if (stack.isEmpty()) {
            return new int[]{-1};
        }
        
        int len = stack.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        Arrays.sort(ans);
        return ans;
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        int cnt = 0;
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            cnt += arr[cur[0]][cur[1]];
            System.out.println("진입: " + arr[cur[0]][cur[1]]);
            
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                
                if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                    if (!visited[nx][ny] && arr[nx][ny] != 0) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println("최종cnt: " + cnt);
        stack.push(cnt);
    }
}