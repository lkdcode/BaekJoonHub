class Solution {
    public int solution(String myString, String pat) {
        if (myString.length() < pat.length()) return 0;
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        
        for (int i = 0; i < myString.length(); i++) {
            
            if (myString.charAt(i) == pat.charAt(0)) {
                if (myString.substring(i).startsWith(pat)) return 1;
            }
            
        }
        
        return 0;
    }
}