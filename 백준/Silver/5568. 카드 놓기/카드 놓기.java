import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int n, cnt, k;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        backtrack(0, sb);

        System.out.println(cnt);

    }

    public static void backtrack(int idx, StringBuilder sb) {
        if (idx == k) {
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int start = sb.length();
                sb.append(arr[i]);
                backtrack(idx+1, sb);
                sb.delete(start, sb.length());
                visited[i] = false;
            }
        }
    }
}
