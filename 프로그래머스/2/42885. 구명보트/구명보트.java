import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        
        while (start <= end) {
            int mp = people[start];
            int ep = people[end];
            
            if (mp + ep <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
            
            cnt++;
        }
        
        return cnt;
    }
}