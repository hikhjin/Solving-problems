class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = findMax(diffs);
        
        while (start < end) {
            int level = (start + end) / 2;
            long cur = calTime(diffs, times, level);
            
            if (cur > limit) {
                start = level + 1;
            } else end = level;
        }
        
        return start;
    }
    
    static long calTime(int[] diffs, int[] times, int level) {
        long cur = times[0];
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] > level) {
                cur += (long) (times[i] + times[i-1]) * (diffs[i] - level);
            }
            cur += times[i];
        }
        return cur;
    }
    
    static int findMax(int[] diffs) {
        int max = 0;
        for (int d : diffs) {
            max = Math.max(d, max);
        }
        return max;
    }
}