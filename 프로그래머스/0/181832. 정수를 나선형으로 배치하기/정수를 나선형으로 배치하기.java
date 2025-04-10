class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int num = 1;
        int srow = 0;
        int scol = 0;
        int erow = n-1;
        int ecol = n-1;
        
        while (num <= n*n) {
            for (int i = scol; i <= ecol; i++) {
                answer[srow][i] = num++;
            }
            srow++;
            
            for (int i = srow; i <= erow; i++) {
                answer[i][ecol] = num++;
            }
            ecol--;
            
            for (int i = ecol; i >= scol; i--) {
                answer[erow][i] = num++;
            }
            erow--;
            
            for (int i = erow; i >= srow; i--) {
                answer[i][scol] = num++;
            }
            scol++;
        }
        return answer;
    }
}