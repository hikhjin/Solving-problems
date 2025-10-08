class Solution {
    static int[] discountRate = new int[]{10,20,30,40};
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        return answer;
    }
    
    static void dfs(int idx, int[] discount, int[][] users, int[] emoticons) {
        if (idx == emoticons.length) {
            cal(discount, users, emoticons);
            return;
        }
        
        for (int rate : discountRate) {
            discount[idx] = rate;
            dfs(idx + 1, discount, users, emoticons);
        }
    }
    
    static void cal(int[] discount, int[][] users, int[] emoticons) {
        int cost = 0; // 이모티콘 구매 비용
        int plusCount = 0; // 이모티콘 플러스 가입자 수
        
        for (int[] user : users) {
            int maxPrice = user[1]; // 최대 가격
            int minRate = user[0]; // 최소 비율
            int userCost = 0; // 사용자별 이모티콘 구매 비용
            
            for (int i = 0; i < emoticons.length; i++) {
                if (minRate <= discount[i]) {
                    int paid = emoticons[i] * (100 - discount[i]) / 100;
                    userCost += paid;
                }
            }
            
            if (userCost >= maxPrice) {
                plusCount++;
            } else {
                cost += userCost;
            }
        }
        
        if (answer[0] < plusCount || (answer[0] == plusCount) && (answer[1] < cost)) {
            answer[0] = plusCount;
            answer[1] = cost;
        }
    }
}