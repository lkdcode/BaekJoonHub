import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (true) {
            if (i == arr.length) break;
            
            if (stack.size() == 0) {
                stack.push(arr[i]);
                i++;
            } else if (stack.peek() < arr[i]) {
                stack.push(arr[i]);
                i++;
            } else if (stack.peek() >= arr[i]) {
                stack.pop();
            }
        }
        
        // System.out.println(stack);
        
        stk = new int[stack.size()];
        
        for (int j = stk.length - 1; j >= 0; j--) {
            stk[j] = stack.pop();
        }
        
        return stk;
    }
}