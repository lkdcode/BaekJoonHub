class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for (int i = 0; i < myString.length(); i++) {
            char check = myString.charAt(i);
            if (check - 0 < 'l' - 0) {
                answer += "l";
            } else {
                answer += String.valueOf(check);
            }
        }
        
        return answer;
    }
}