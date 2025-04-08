import java.util.*;

class Solution {
    static boolean[][] visited;
    static int row, col;
    static int[] oil; // 열별 석유량 저장

    public int solution(int[][] land) {
        row = land.length;
        col = land[0].length;
        oil = new int[col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < col; i++) {
            ans = Math.max(ans, oil[i]);
        }
        return ans;
    }

    static void bfs(int x, int y, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 0;
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            cnt++;
            set.add(cur[1]); // 열 번호 저장

            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
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
