import java.util.*;

class Solution {
    private static int[] DX = {1, -1, 0, 0, 1, -1, 1, -1};
    private static int[] DY = {0, 0, 1, -1, 1, -1, -1, 1};
    public int solution(int[][] board) {
        int answer = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    
                    for (int k = 0; k < 8; k++) {
                        int newX = i + DX[k];
                        int newY = j + DY[k];
                        
                        if (newX >= 0 && newX < board.length
                           && newY >= 0 && newY <board[i].length
                           && board[newX][newY] == 0) {
                            board[newX][newY] = 2;
                        }
                    }
                }
            }
        }
        
          
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        
        
        return answer;
    }
}