import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] arr;
    static int minMaxDist = Integer.MAX_VALUE; // 가장 큰 거리값이 가장 작을 때의 거리
    static int[] selected; // 선택된 인덱스 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 전체 집 개수
        K = Integer.parseInt(st.nextToken()); // 대피소 설치할 집 개수

        arr = new int[N][2];
        selected = new int[K];

        for (int i = 0; i < N; i++) { // 배열에 저장
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(minMaxDist);

    }

    static void dfs(int idx, int depth) { // 조합 구하기
        if (depth == K) {
            int maxDist = 0;
            for (int i = 0; i < N; i++) {
                int minDist = Integer.MAX_VALUE; // 가장 가까운 대피소

                for (int j = 0; j < K; j++) {
                    int shelterIdx = selected[j];
                    int dist = Math.abs(arr[i][0] - arr[shelterIdx][0]) + Math.abs(arr[i][1] - arr[shelterIdx][1]);
                    minDist = Math.min(minDist, dist); // 가장 가까운 대피소 거리
                }
                maxDist = Math.max(maxDist, minDist); // 그 중 가장 먼 집
            }
            minMaxDist = Math.min(minMaxDist, maxDist); // 그 중 가장 작은 최대 거리
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
