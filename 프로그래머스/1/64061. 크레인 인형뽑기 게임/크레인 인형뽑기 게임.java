import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            int index = move - 1;
            
            for (int i = 0; i < board.length; i++) {
                if (board[i][index] == 0) continue;
                
                int doll = board[i][index];
                board[i][index] = 0;
                
                if (stack.size() == 0) {
                    stack.push(doll);
                    break;
                }
                
                if (stack.peek() != doll) {
                    stack.push(doll);
                    break;
                }
                
                if (stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                    break;
                }
                    
            }
        }
        
        return answer;
    }
}