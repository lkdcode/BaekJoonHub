import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] list = new int[3];
        int index = 0;
        for (int i = 1; i <= rank.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                if (attendance[j] && rank[j] == i) {
                    list[index++] = j;
                    break;
                }
            }
            if (index == 3) break;
        }
        
        answer = (10000 * list[0]) + (100 * list[1]) + list[2];
    
        return answer;
    }
}