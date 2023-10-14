import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        sum *= sum;
        
        return sum > Arrays.stream(num_list).reduce(1, (a, b) -> a * b) ? 1 : 0;
    }
}