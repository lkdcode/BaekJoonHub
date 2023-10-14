class Solution {
    public String solution(String n_str) {        
        if (n_str.charAt(0) != '0') return n_str;
        
        int endIndex = 1;
        
        for (int i = 1; i < n_str.length(); i++) {
            if (n_str.charAt(i) != '0') {
                endIndex = i;
                break;
            }
        }
        
        return n_str.substring(endIndex);
    }
}