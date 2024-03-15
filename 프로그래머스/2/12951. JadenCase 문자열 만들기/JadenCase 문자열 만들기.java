class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            
            if (target == ' ') {
                answer += " ";
                flag = true;
            } else { 
                if (flag) {
                    answer += String.valueOf(target).toUpperCase();
                } else {
                    answer += String.valueOf(target).toLowerCase();
                }
                flag = false;
            }
        }
        
        return answer;
    }
}