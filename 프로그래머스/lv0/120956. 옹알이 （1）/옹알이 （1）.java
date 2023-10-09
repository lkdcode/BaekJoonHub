import java.util.*;

class Solution {
    
    private static final String[] WORD = {"aya", "ye", "woo", "ma"};
    private static final Map<String, Integer> MAP = new HashMap<>();
    private static final boolean[] visited = new boolean[4];
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i <= 4; i++) {
            make(new StringBuilder(), 0, i);
        }
        MAP.remove("");
        
        for (String check : babbling) {
            if(MAP.containsKey(check)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void make(StringBuilder sb, int depth, int size) {
        if (depth == size) {
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                input.append(WORD[Integer.parseInt(String.valueOf(sb.charAt(i)))]);
            }

            MAP.put(input.toString(), 1);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                make(sb.append(i), depth + 1, size);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    
}