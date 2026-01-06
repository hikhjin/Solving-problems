import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int idx = 1;

        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(br.readLine());
            
            while (idx <= now) {
                stack.push(idx);
                sb.append("+\n");
                idx++;
            }

            if (stack.peek() == now) {
                stack.pop();
                sb.append("-\n");
            }  else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}