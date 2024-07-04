import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)(Math.pow(2, N) - 1));
        solve(N, 1, 3, 2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int N, int start, int end, int aux) {
        if (N == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        solve(N-1, start, aux, end);
        sb.append(start).append(" ").append(end).append("\n");
        solve(N-1, aux, end, start);
    }
}
