import java.util.*;

class Solution {
    public int solution(String s) {       
        if (s.length() % 2 != 0) return 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == target) stack.pop();
            else stack.push(target);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}