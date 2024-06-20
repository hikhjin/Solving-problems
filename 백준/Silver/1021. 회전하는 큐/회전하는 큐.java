import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수 개수
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());

            while (deque.peekFirst() != tmp) {
                if ((deque.size() / 2) >= deque.indexOf(tmp)) {
                    deque.addLast(deque.removeFirst());
                    cnt++;
                } else {
                    deque.addFirst(deque.removeLast());
                    cnt++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(cnt);
    }
}
