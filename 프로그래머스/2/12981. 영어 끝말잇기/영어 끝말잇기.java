import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        
        Stack<String> stack = new Stack<>();

        int index = 0;

        for (String word : words) {
            if (stack.isEmpty()) {
                stack.add(word);
                index++;
                continue;
            }

        if (!stack.peek().endsWith(String.valueOf(word.charAt(0))) || stack.contains(word)) {
            int order = (index % n) + 1;
            int step = (index / n) + 1;

            return new int[]{order, step};
            } else {
                stack.add(word);
                index++;
            }
        }
        
        return new int[]{0, 0};
    }
}