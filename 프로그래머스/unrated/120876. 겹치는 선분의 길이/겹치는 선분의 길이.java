import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] check = new int[201];
        
        for (int[] point : lines) {
            int startPoint = point[0] + 100;
            int endPoint = point[1] + 100 - 1;
            
            for (int i = startPoint; i <= endPoint; i++) {
                check[i]++;
            }
        }
        
        for (int c : check) {
            if (c >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}