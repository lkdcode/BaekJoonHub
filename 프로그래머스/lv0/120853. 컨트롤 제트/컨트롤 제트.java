import java.util.*;

class Solution {
    public int solution(String s) {
        String[] str = s.split(" ");
        List<String> arr = new ArrayList<>(Arrays.asList(str));
        // while (arr.contains("Z")) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).equals("Z")) {
                    arr.remove(i);
                    arr.remove(i - 1);
                    i = 0;
                }
            }
        // }
        int answer = 0;
        for (int i = 0; i < arr.size(); i++) {
            answer += Integer.parseInt(arr.get(i));
        }
        return answer;
    }
}