import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int[][] paper = new int[wallpaper.length][wallpaper[0].length()];
        int rowMin = Integer.MAX_VALUE;
        int rowMax = Integer.MIN_VALUE;
        
        int columnMin = Integer.MAX_VALUE;
        int columnMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    paper[i][j]++;
                    rowMin = Math.min(i, rowMin);
                    rowMax = Math.max(i, rowMax);
                    
                    columnMin = Math.min(j, columnMin);
                    columnMax = Math.max(j, columnMax);
                }
            }
        }
        
        answer[0] = rowMin;
        answer[1] = columnMin;
        answer[2] = ++rowMax;
        answer[3] = ++columnMax;
        
        return answer;
    }
}