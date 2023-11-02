import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] size = new int[31];
        
        for (int i = 0; i < strArr.length; i++) {
            int length = strArr[i].length();
            
            size[length]++;
        }
        
        int maxSize = -1;
        for (int s : size) {
            maxSize = Math.max(maxSize, s);
        }
        
        return maxSize;
    }
}