import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        
        int[] division = new int[10_000_001];
        for (int i : tangerine) {
            division[i]++;
        }

        Arrays.sort(division);

        for (int i = division.length - 1; i >= 0; i--) {
            if (k <= 0) break;
            answer++;
            k -= division[i];
        }
        
        return answer;
    }
}