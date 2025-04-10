import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String target = br.readLine() ;

        for (int i = 1; i < N; i++) {
            String s = br.readLine();
            int cnt = 0; // 일치하는 문자 수
            int[] word = new int[26];
            for (int j = 0; j < target.length(); j++) {
                word[target.charAt(j) - 'A']++;
            }

            for (int j = 0; j < s.length(); j++) {
                if (word[s.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[s.charAt(j) - 'A']--;
                }
            }

            if (target.length() == s.length() && (target.length() == cnt || target.length() - 1 == cnt)) {
                ans++;
            } else if (target.length() == s.length() - 1 && s.length() - 1 == cnt) {
                ans++;
            } else if (target.length() == s.length() + 1 && s.length() == cnt) {
                ans++;
            }

        }
        System.out.println(ans);

    }
}
