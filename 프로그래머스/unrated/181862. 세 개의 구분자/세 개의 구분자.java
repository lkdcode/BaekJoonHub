import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {"EMPTY"};
        
        String[] answer1 = Arrays
            .stream(myStr.split("[abc]"))
            .filter(e -> !e.isEmpty())
            .toArray(String[]::new);
        
        return Arrays.stream(myStr.split("[abc]"))
            .filter(e -> !e.isEmpty())
            .toArray(String[]::new)
            .length == 0 ? new String[]{"EMPTY"} : Arrays.stream(myStr.split("[abc]"))
            .filter(e -> !e.isEmpty())
            .toArray(String[]::new);
    }
}