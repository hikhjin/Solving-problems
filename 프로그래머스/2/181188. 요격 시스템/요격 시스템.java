import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]); // 끝나는 구간 기준 오름차순 정렬
        
        int now = 0; // 현재 미사일 위치
        for (int[] n : targets) {
            if (n[0] >= now) {
                now = n[1];
                answer++;
            }
        }
        return answer;
    }
}