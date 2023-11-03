import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        
        boolean isArithmetic = IntStream.range(0, common.length - 2)
            .allMatch(i -> (common[i + 1] - common[i] == common[i + 2] - common[i + 1]));
        
        if (isArithmetic) {
            int length = common.length;
            int arithmetic = common[length - 1] - common[length - 2];
            return arithmetic + common[length - 1];
        }
        
        int geometric = common[1] / common[0];
        
        return geometric * common[common.length - 1];
    }
}