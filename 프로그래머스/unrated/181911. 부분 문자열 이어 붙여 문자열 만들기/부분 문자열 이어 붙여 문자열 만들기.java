class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        
        int strIndex = 0;
        
        for (int[] part : parts) {
            int startIndex = part[0];
            int endIndex = part[1];
            
            answer += my_strings[strIndex++].substring(startIndex, endIndex + 1);
        }
        
        return answer;
    }
}