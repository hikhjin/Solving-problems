class Solution {
    int solution(int[][] land) {
        int N = land.length;
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == j) continue;
                    max = Math.max(max, land[i-1][k]);
                }
                land[i][j] += max;
            }
        }
        
        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(land[N-1][i], max);
        }
        return max;
    }
}