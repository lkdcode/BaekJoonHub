class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int bottle = n / a;
            
            answer += bottle * b;
            
            n = n - (bottle * a) + (bottle * b);
        }
        
        return answer;
    }
}