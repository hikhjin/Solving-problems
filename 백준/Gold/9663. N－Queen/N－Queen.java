import java.io.*;

public class Main {
    static boolean[] checkCol; // 가로
    static boolean[] checkDigL; // 왼쪽 대각선
    static boolean[] checkDigR; // 오른쪽 대각선
    static int N;
    static int queen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checkCol = new boolean[N];
        checkDigL = new boolean[N*2-1];
        checkDigR = new boolean[N*2-1];

        solve(0);
        System.out.println(queen);
    }

    static void solve(int cnt) {
        if (cnt == N) {
            queen++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (checkCol[i] || checkDigL[i + cnt] || checkDigR[i - cnt + N - 1]) { // 놓을 수 없으면
                continue;
            }
            checkCol[i] = true;
            checkDigL[cnt + i] = true;
            checkDigR[i - cnt + N - 1] = true;
            solve(cnt + 1);
            checkCol[i] = false;
            checkDigL[cnt + i] = false;
            checkDigR[i - cnt + N - 1] = false;
        }

    }
}
