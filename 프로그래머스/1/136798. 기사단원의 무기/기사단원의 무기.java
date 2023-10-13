class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] numbers = new int[number + 1];
        
        for (int i = 1; i <= number; i++) {
            numbers[i - 1] = countDivisors(i);
        }
        
        for (int weapon : numbers) {
            if (weapon > limit) {
                answer += power;
            } else {
                answer += weapon;
            }
        }
        
        return answer;
    }
    
    private int countDivisors(int number) {
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i * i == number) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        
        return count;
    }
}