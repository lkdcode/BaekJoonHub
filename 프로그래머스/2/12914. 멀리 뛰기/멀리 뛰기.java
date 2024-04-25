class Solution {
    public long solution(int n) {
        final int[] numbers = new int[2_001];
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 3;

        for (int i = 4; i <= n; i++) {
            numbers[i] = (numbers[i - 1] + numbers[i - 2]) % 1_234_567;
        }

        return numbers[n];
    }
}