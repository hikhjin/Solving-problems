class Solution {
    static boolean[] checkCol;
    static boolean[] checkDigL;
    static boolean[] checkDigR;
    static int answer = 0;
    
    public int solution(int n) {
        checkCol = new boolean[n];
        checkDigL = new boolean[n * 2 - 1];
        checkDigR = new boolean[n * 2 - 1];
        
        backTrack(n, 0);
        
        return answer;
    }
    
    static void backTrack(int n, int cnt) {
        if (n == cnt) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (checkCol[i] || checkDigL[i+cnt] || checkDigR[i-cnt+n-1]) continue;
            
            checkCol[i] = true;
            checkDigL[i+cnt] = true;
            checkDigR[i-cnt+n-1] = true;
            
            backTrack(n, cnt+1);
            
            checkCol[i] = false;
            checkDigL[i+cnt] = false;
            checkDigR[i-cnt+n-1] = false;
        }
    }
}