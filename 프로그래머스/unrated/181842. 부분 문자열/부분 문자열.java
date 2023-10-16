class Solution {
    public int solution(String str1, String str2) {
    
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(0)) {
                if (str2.substring(i).startsWith(str1)) return 1;
            }
        }
        
        return 0;
    }
}