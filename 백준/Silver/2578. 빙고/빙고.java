import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                find(num);
//                System.out.println("num = " + num);
//                printMap(map);

                int cnt = checkRow() + checkCol() + checkDiaL() + checkDiaR();

//                System.out.println("checkRow = " + checkRow() + ", checkCol = " + checkCol() + ", checkDiaL = " + checkDiaL() + ", checkDiaR = " + cnt);
                if (cnt >= 3) {
                    int ans = i * 5 + j + 1;
                    System.out.println(ans);
                    return;
                }
            }
        }
    }

    static void printMap(int[][] map) {
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
    }

    static void find(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == num) map[i][j] = -1;
            }
        }
    }

    static int checkRow() { // 세로 빙고 체크
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] != -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        return cnt;
    }

    static int checkCol() { // 가로 빙고 체크
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 5; j++) {
                if (map[j][i] != -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        return cnt;
    }

    static int checkDiaL() { // 대각선 빙고 체크
        int cnt = 0;
        boolean flag = true;

        for (int i = 0; i < 5; i++) {
            if (map[i][i] != -1) {
                flag = false;
                break;
            }
        }
        if (flag) cnt++;
        return cnt;
    }

    static int checkDiaR() {
        int cnt = 0;
        boolean flag = true;

        for (int i = 0; i < 5; i++) {
            if (map[i][4-i] != -1) {
                flag = false;
                break;
            }
        }
        if (flag) cnt++;
        return cnt;
    }
}
