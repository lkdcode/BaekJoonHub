class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
                
        for (String str : str_list) {
            boolean flag = true;
            
            for (int i = 0; i <= str.length() - ex.length(); i++) {
                if (str.substring(i, i + ex.length()).equals(ex)) flag = false;
            }
            
            if (flag) answer += str;
        }
        
        return answer;
    }
}