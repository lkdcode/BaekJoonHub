class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        for (int i = 0; i < my_string.length(); i++) {
            if (i == s) {
                int index = e;
                for (int j = s; j <= e; j++) {
                    answer += String.valueOf(my_string.charAt(index--));
                }
                i = e;
                continue;
            }
            answer += String.valueOf(my_string.charAt(i));
        }
        
        return answer;
    }
}