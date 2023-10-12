import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int N = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        System.out.println(set.size() + " < < < ");
        System.out.println(N);
        
        
        return N < set.size() ? N : set.size();
    }
}