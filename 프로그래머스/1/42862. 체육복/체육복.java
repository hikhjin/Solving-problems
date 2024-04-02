class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] check = new int[n]; // 체육복 있는 학생 배열
        for (int i = 0; i < n; i++) {
            check[i] = 1; // 초기화
        }
        
        for (int i = 0; i < lost.length; i++) {
            check[lost[i]-1] -= 1; // 체육복 없는 학생 0
        }
        
        for (int i = 0; i < reserve.length; i++) {
            check[reserve[i]-1] += 1; // 여벌 체육복 있는 학생 2
        }
        
        for (int i = 0; i < n; i++) {
            if (check[i] == 0) { // 체육복 없을 경우
                if (i != 0 && check[i-1] == 2) {
                    check[i] += 1;
                    check[i-1] -= 1;
                } else if (i != n-1 && check[i+1] == 2) {
                    check[i] += 1;
                    check[i+1] -= 1;
                } 
            }
        }
        
        for (int c : check) {
            if (c > 0) {
                answer += 1;
            }
        }
        return answer;
    }
}