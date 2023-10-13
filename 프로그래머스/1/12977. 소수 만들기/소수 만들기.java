import java.util.*;

class Solution {
    
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] nonPrimeNumbers = new boolean[5000];
        
        for (int i = 2; i < nonPrimeNumbers.length; i++) {
            for (int j = i * 2; j < nonPrimeNumbers.length; j += i) {
                nonPrimeNumbers[j] = true;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (!nonPrimeNumbers[nums[i] + nums[j] + nums[k]]) answer++;
                }
            }
        }
        
        return answer;
    }

}