class Solution {
    int[] answer = new int[2];
    int[] sales = new int[]{10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, users, emoticons, new int[emoticons.length]);
        return answer;
    }

    // 모든 할인율 조합 탐색
    private void dfs(int idx, int[][] users, int[] emoticons, int[] discount) {
        if (idx == emoticons.length) {
            calculate(users, emoticons, discount);
            return;
        }

        for (int rate : sales) {
            discount[idx] = rate;
            dfs(idx + 1, users, emoticons, discount);
        }
    }

    // 현재 할인율 조합으로 가입자수/매출 계산
    private void calculate(int[][] users, int[] emoticons, int[] discount) {
        int plusCount = 0;
        int totalSales = 0;

        for (int[] user : users) {
            int needRate = user[0];
            int maxPrice = user[1];
            int cost = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discount[i] >= needRate) {
                    cost += emoticons[i] * (100 - discount[i]) / 100;
                }
            }

            if (cost >= maxPrice) plusCount++;
            else totalSales += cost;
        }

        if (plusCount > answer[0] || (plusCount == answer[0] && totalSales > answer[1])) {
            answer[0] = plusCount;
            answer[1] = totalSales;
        }
    }
}
