class Solution {
    public int solution(int n) {
        int[] numbers = new int[n + 1];
        int answer = 0;
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            numbers[i] = (numbers[i - 1] + numbers[i - 2]) % 1_234_567;
        }
        
        return numbers[n];
    }
}