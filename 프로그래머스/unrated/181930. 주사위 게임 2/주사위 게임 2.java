class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        if (a != b && a != c && b != c) return a + b + c;
        
        if (a == b && b == c) {
            return (a + b + c) 
                * ((a * a) + (b * b) + (c * c)) 
                * ((a * a * a) + (b * b * b) + (c * c * c));
        }
        
        return (a + b + c) * ((a * a) + (b * b) + (c * c));
    }
}