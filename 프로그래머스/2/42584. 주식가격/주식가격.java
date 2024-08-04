class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        int[] check = new int[n]; // 가격 측정 끝났는지 여부
        
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) continue; // 이미 처리된 경우 건너뜀
            for (int j = i + 1; j < n; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) {
                    check[i] = 1; // 가격이 떨어진 경우 표시
                    break;
                }
            }
        }
        
        return answer;
    }
}
