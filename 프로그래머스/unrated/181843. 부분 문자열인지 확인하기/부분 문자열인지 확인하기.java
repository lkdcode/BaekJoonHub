class Solution {
    public int solution(String my_string, String target) {
        
        char startChar = target.charAt(0);
        
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) == startChar) {
                if (my_string.substring(i).startsWith(target)) return 1;
            }
        }
        
        return 0;
    }
}