class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        s = s.toUpperCase();
        int cntP = 0;
        int cntY = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                cntP++;
            } else if (s.charAt(i) == 'Y') {
                cntY++;
            }
        }
        
        if (cntP == cntY) {
            answer = true;
        }

        return answer;
    }
}