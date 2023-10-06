class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long length = p.length();
        
        long number = Long.parseLong(p);
        
        for (long i = 0; i <= t.length() - length; i++) {
            int startIndex = (int) i;
            int endIndex = (int) (i + length);
            
            String substring = t.substring(startIndex, endIndex);
            
            long checkNumber = Long.parseLong(substring);
            
            if (number >= checkNumber) answer++;            
        }
        
        
        return answer;
    }
}