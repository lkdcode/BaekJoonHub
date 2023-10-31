import java.util.*;

class Solution {
    public String[] solution(String myString) {
        
        return Arrays.stream(myString.split("x"))
            .filter(e -> !e.isEmpty())
            .sorted()
            .toArray(String[]::new);
    }
}