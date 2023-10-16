import java.util.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr;
        int arraySize = arr.length;
        
        if (arraySize % 2 == 1) {
            for (int i = 0; i < arraySize; i += 2) {
                answer[i] = arr[i] + n;
            }
        } else {
            for (int i = 1; i < arraySize; i += 2) {
                answer[i] = arr[i] + n;
            }
        }

        return answer;
    }
}