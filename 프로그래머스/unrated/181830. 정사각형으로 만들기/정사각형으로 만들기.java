import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        
        int row = arr.length;
        int column = arr[0].length;
        
        if (row == column) {
            return arr;
        }
        
        if (row > column) {
            int[][] rowResult = new int[row][row];
            
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    rowResult[i][j] = arr[i][j];
                }
            }
            
            return rowResult;
        }
        
        if (column > row) {
            int[][] columnResult = new int[column][column];
            
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    columnResult[i][j] = arr[i][j];
                }
            }
            
            return columnResult;
        }
        
        
        System.out.println(row);
        System.out.println(column);
        
        return answer;
    }
}