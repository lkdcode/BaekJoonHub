class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int number = i;
            for (int j = i + 1; j <= n; j++) {
                if (number > n) break;
                if (number == n) answer++;

                number += j;
            }
        }
        return answer + 1;
    }
}