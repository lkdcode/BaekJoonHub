class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        for (int number : arr) {
            answer = lcm(number, answer);
        }
        
        return answer;
    }
    
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}