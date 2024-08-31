import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int answer = Integer.MAX_VALUE;

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 그래프에 엣지 추가
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        // 각 엣지를 한 번씩 제거하고 최소 차이 찾기
        for (int[] wire : wires) {
            // 전선 끊기
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));

            // BFS 탐색
            boolean[] visited = new boolean[n + 1];
            int cnt1 = BFS(graph, wire[0], visited);

            // 다시 전선 붙이기
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);

            // 두 서브 그래프의 차이 계산
            int cnt2 = n - cnt1;
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
        }
        return answer;
    }

    // BFS 함수
    int BFS(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : graph.get(poll)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
