import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        int[] x = Arrays.stream(polynomial.split(" "))
            .filter(e -> e.contains("x"))
            .map(e -> e.replace("x", ""))
            .map(e -> e.isEmpty() ? "1" : e)
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int[] number = Arrays.stream(polynomial.split(" "))
            .filter(e -> e.matches("^[\\d]*$"))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int xCount = Arrays.stream(x).sum();
        int numberSum = Arrays.stream(number).sum();
        
        System.out.println(xCount + "       " + numberSum);
        
        String xResult = "";
        String numberResult = "";
        
        if (xCount == 0) {
            xResult = "";
        } else if (xCount == 1) {
            xResult = "x";
        } else {
            xResult = xCount + "x";
        }
        
        if (numberSum == 0) {
            numberResult = "";
        } else if (xCount == 0 && numberSum != 0) {
            return String.valueOf(numberSum);
        } else {
            numberResult = " + " + numberSum;
        }
        
        return xResult + numberResult;
    }
}