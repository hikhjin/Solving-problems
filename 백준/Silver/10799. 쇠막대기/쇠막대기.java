import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;
        int cnt = 0; // 현재 막대기 개수

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
//                System.out.println("c='('");
            } else {
                if (s.charAt(i-1) == '(') { // 레이저
                    cnt--;
                    ans += cnt;
//                    System.out.println("레이저");
                } else {
                    cnt--;
                    ans++;
//                    System.out.println("c=')'");
                }
            }
        }
        System.out.println(ans);
    }
}
