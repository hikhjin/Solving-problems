class Solution {
    static int max = 0;
    static boolean[] visited;
    
    public int solution(int[] cards) {
        int len = cards.length;
        
        for (int i = 0; i < len; i++) {
            visited = new boolean[len];
            int g1 = counting(i, cards);
            
            for (int j = 0; j < len; j++) {
                if (!visited[j]) {
                    int g2 = counting(j, cards);
                    max = Math.max(max, g1 * g2);
                }
            }
        }
        return max;
    }
    
    static int counting(int idx, int[] cards) {
        int cnt = 0;
        while (!visited[idx]) {
            visited[idx] = true;
            idx = cards[idx] - 1;
            cnt++;
        }
        return cnt;
    }
}