import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = Integer.toString(n); // 문자열로 변환
        
        for (String s : tmp.split("")) {
            answer+= Integer.parseInt(s);
        }

        return answer;
    }
}