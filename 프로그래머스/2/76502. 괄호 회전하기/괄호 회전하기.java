import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        s += s;

        for (int i = 0; i < s.length() / 2; i++) {
            if (validBracket(s.substring(i, i + length))) answer++;
        }
        
        return answer;
    }
    
    private static boolean validBracket(String target) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if (stack.peek() == '[' && ch == ']') {
                stack.pop();
                continue;
            }
            if (stack.peek() == '{' && ch == '}') {
                stack.pop();
                continue;
            }
            if (stack.peek() == '(' && ch == ')') {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }

        return stack.size() == 0;
    }
}