class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
     
        char[] list = my_string.toCharArray();
        
        for (int i = c - 1; i < list.length; i += m) {
            answer += String.valueOf(list[i]);
        }
        
        return answer;
    }
}