class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            
            // System.out.println(i + " ");
            
            char x = s.charAt(i);
            
            int xCount = 1;
            int anotherCount = 0;
            
            for (int j = i + 1; j < s.length(); j++) {
                char another = s.charAt(j);
                
                if (x == another) xCount++;
                else anotherCount++;
                
                if (xCount == anotherCount) break;
            }
            
            i += xCount + anotherCount - 1;
            
            answer++;
        }
        
        return answer;
        
    }
}