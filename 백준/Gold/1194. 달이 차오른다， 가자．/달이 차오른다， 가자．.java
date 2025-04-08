import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] maze;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        maze = new char[N][M];
        visited = new boolean[N][M][64];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j);
                if (maze[i][j] == '0') { // 시작 위치일 경우
                    startX = i;
                    startY = j;
                }
            }
        }

        int ans = bfs(startX, startY);
        System.out.println(ans);
    }

    static int bfs(int x, int y) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0, 0));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (maze[cur.x][cur.y] == '1') return cur.cost; // 출구 도착한 경우

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] != '#' && !visited[nx][ny][cur.key]) {
                    if (maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') { // 열쇠에 도착
                        int nextKey = 1 << (maze[nx][ny] - 'a');
                        nextKey = nextKey | cur.key; // OR 연산으로 키 추가
                        visited[nx][ny][nextKey] = true;
                        queue.offer(new Node(nx, ny, cur.cost+1, nextKey));
                    } else if (maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F') { // 문에 도착
                        if ((cur.key & (1 << (maze[nx][ny] - 'A'))) > 0) {
                            visited[nx][ny][cur.key] = true;
                            queue.offer(new Node(nx, ny, cur.cost+1, cur.key));
                        }
                    } else { // 빈칸, 0일 경우
                        visited[nx][ny][cur.key] = true;
                        queue.offer(new Node(nx, ny, cur.cost+1, cur.key));
                    }
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x, y; // 현재 위치
        int cost; // 움직인 거리
        int key; // 현재 키

        Node(int x, int y, int cost, int key) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }
    }
}
