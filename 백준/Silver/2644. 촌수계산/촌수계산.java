import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine()); // 관계 개수

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        int ans = BFS(num1, num2, graph, n);
        System.out.println(ans);
    }

    public static int BFS(int start, int end, Map<Integer, List<Integer>> graph, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.offer(new int[]{start, 0}); // 현재 촌수는 0
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == end) {
                return cur[1];
            }

            for (int next : graph.get(cur[0])) {
                if (!visited[next]) {
                    queue.offer(new int[]{next, cur[1] + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
