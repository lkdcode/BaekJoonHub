import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        
        // System.out.println(Arrays.toString(myString.split("x")));
        
        for (String s : myString.split("x")) {
            // System.out.print(s.length() + " ");
            list.add(s.length());
        }
        
        if (myString.charAt(myString.length() - 1) == 'x') {
            list.add(0);
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}