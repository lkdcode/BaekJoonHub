import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        if (arr1.length < arr2.length) return -1;
        
        if (Arrays.stream(arr1).sum() > Arrays.stream(arr2).sum()) return 1;
        if (Arrays.stream(arr1).sum() < Arrays.stream(arr2).sum()) return -1;

        return 0;
    }
}