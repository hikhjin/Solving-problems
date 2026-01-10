import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{Integer.parseInt(st.nextToken()), 1}); // 첫번째꺼 넣기, 이때 무조건 0
        sb.append(0).append(" ");

        for (int i = 1; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[0] < now) {
                stack.pop();
            }

            if (stack.isEmpty()) sb.append(0).append(" ");
            else sb.append(stack.peek()[1]).append(" ");
            stack.push(new int[]{now, i+1});
        }

        System.out.println(sb.toString().trim());
    }
}
