import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] arr = br.readLine().toCharArray();
            int ans = 0;
            int tmp = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'O') {
                    if (j != 0 && arr[j-1] == 'O') { // 연속 O 일 경우
                        tmp++;
                        if (j == arr.length-1) {
                            if (tmp != 0) {
                                for (int k = 2; k <= tmp + 1; k++) {
                                    ans += k;
                                }
                            }
                        }
                    } else {
                        ans++;
                    }
                } else { // X 일 경우
                    if (tmp != 0) {
                        for (int k = 2; k <= tmp + 1; k++) {
                            ans += k;
                        }
                    }
                    tmp = 0;
                }
            }
            System.out.println(ans);
        }

    }
}
