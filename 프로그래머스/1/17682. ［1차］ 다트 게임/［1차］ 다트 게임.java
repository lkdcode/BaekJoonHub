import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
    
        int[] point = new int[3];
        String[] bonus = new String[3];
        String[] option = new String[3];
        
        int pointIndex = 0;
        
        String inputPoint = "";
        
        for (int i = 0; i < dartResult.length(); i++) {
            char check = dartResult.charAt(i);
            
            if (check == 'S'
               || check == 'D'
               || check == 'T') {
                point[pointIndex] = Integer.parseInt(inputPoint.replaceAll("[#*]", ""));
                bonus[pointIndex++] = String.valueOf(check);
                inputPoint = "";
                continue;
            }
            
            inputPoint += check; 
        }
        
        for (int i = 0; i < point.length; i++) {
            if (bonus[i].equals("D")) {
                point[i] = point[i] * point[i];
            }
            if (bonus[i].equals("T")) {
                point[i] = point[i] * point[i] * point[i];
            }
        }
        
        for (int i = 0; i < dartResult.length(); i++) {
            char check = dartResult.charAt(i);
            
            if (check == '*' || check == '#') {
                if (i < 3) option[0] = String.valueOf(check);
                else if (i == dartResult.length() - 1) option[2] = String.valueOf(check);
                else option[1] = String.valueOf(check);
            }   
        }
        
        ///////////////////////////////////////
        
        
        // for (int i : point) {
        //     System.out.print(i + " ");
        // }
        
        ///////////////////////////////////////
        
        // for (String s : option) {
        //     System.out.println(s);
        // }
        
        ///////////////////////////////////////
        
        for (int i = 0; i < option.length; i++) {
            if (option[i] == null) continue;
            
            if (option[i].equals("#")) {
                point[i] -= point[i] * 2;
            }
            
            if (option[i].equals("*")) {
                point[i] += point[i];
                int preIndex = i - 1;
                
                if (preIndex >= 0) point[preIndex] += point[preIndex]; 
            }
        }
        
        ///////////////////////////////////////
        
        // System.out.println();
        // for (int i : point) {
        //     System.out.print(i + " ");
        // }
        
        ///////////////////////////////////////
        
        return Arrays.stream(point).sum();
    }
}