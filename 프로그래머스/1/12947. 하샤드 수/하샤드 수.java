class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int sum = 0;
        int num = x;
        while (x / 10 != 0) {
            sum += x % 10;
            x = x / 10;
        }
        sum += x;
        if (num % sum == 0) answer = true;
        return answer;
    }
}