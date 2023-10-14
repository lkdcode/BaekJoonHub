import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        String newMyString = "";
        
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'A') newMyString += "B";
            if (myString.charAt(i) == 'B') newMyString += "A";
        }
        
        for (int i = 0; i < newMyString.length(); i++) {
            if (newMyString.charAt(i) == pat.charAt(0)) {
                if (newMyString.substring(i).startsWith(pat)) return 1;
            }
        }
        
        return 0;
    }
}