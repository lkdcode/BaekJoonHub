class Solution {
    
    private static int[] DX = new int[]{1, -1, 0, 0};
    private static int[] DY = new int[]{0, 0, 1, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String targetColor = board[h][w];
        int maxSize = board.length;
        
        for (int i = 0; i < 4; i++) {
            int newX = h + DX[i];
            int newY = w + DY[i];
            
            if (newX >= 0 && newX < maxSize
               && newY >= 0 && newY < maxSize
               && board[newX][newY].equals(targetColor)) {
                answer++;
            }
        }
        
        return answer;
    }
}