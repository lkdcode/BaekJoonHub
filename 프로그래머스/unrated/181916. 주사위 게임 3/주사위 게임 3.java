import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        int[] dice = new int[7];
        
        dice[a]++;
        dice[b]++;
        dice[c]++;
        dice[d]++;
        
        for (int i = 1; i < dice.length; i++) {
            if (dice[i] == 4) return 1111 * i;
            
            if (dice[i] == 3) {
                for (int j = 1; j < dice.length; j++) {
                    if (dice[j] == 1) {
                        return (int) Math.pow((10 * i + j), 2); 
                    }
                }
            }
            
            if (dice[i] == 2) {
                for (int j = 1; j < dice.length; j++) {
                    if (dice[j] == 2 && i != j) {
                        return (i + j) * Math.abs(i - j);
                    }
                    if (dice[j] == 1) {
                        for (int k = 1; k < dice.length; k++) {
                            if (j != k && dice[k] == 1) {
                                return j * k;
                            }
                        }
                    }
                }
                
            }
        }
        
        
        
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}