import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long ans = 0;

        for (int i = 1; i < N; i++) {
            ans +=  (N * i) + i;
        }
        System.out.println(ans);
    }
}
