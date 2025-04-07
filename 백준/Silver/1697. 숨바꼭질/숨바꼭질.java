import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 목표 위치

        if (N == K) {
            System.out.println(0);
            return;
        } else {
            bfs(N);
        }
        System.out.println(visited[K]);
    }

    static void bfs(int now) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visited[now] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                break;
            }

            if (cur + 1 <= 100000 && visited[cur + 1] == 0) {
                queue.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
            }
            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                queue.add(cur - 1);
                visited[cur - 1] = visited[cur] + 1;
            }
            if (cur * 2 <= 100000 && visited[cur * 2] == 0) {
                queue.add(cur * 2);
                visited[cur * 2] = visited[cur] + 1;
            }
        }
    }
}
