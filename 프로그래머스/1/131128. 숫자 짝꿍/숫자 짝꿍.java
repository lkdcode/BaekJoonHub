import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] xList = new int[10];
        int[] yList = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            char check = X.charAt(i);
            xList[check - 48]++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            char check = Y.charAt(i);
            yList[check - 48]++;
        }
        
        List<String> list = new ArrayList<>();
        
        for (int i = 9; i >= 0; i--) {
            if (xList[i] != 0 && yList[i] != 0) {
                for (int j = 0; j < Math.min(xList[i], yList[i]); j++) {
                    list.add(i + "");
                }
            }
        }

        if (list.size() == 0) return "-1";
        if (list.get(0).equals("0")) return "0";
     
        for (String number : list) {
            answer.append(number);
        }
        
        return answer.toString();
    }
}