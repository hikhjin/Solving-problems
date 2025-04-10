import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 칭호 개수
        int M = Integer.parseInt(st.nextToken()); // 캐릭터 개수

        int[] arr = new int[N]; // 칭호 기준 배열
        String[] name = new String[N]; // 칭호 이름 배열
        int[] power = new int[M]; // 캐릭터 전투력

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N-1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] < now) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(name[left]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
