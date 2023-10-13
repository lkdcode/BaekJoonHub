class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        int index = 0;
        for (int number : arr) {
            if (number >= 50 && number % 2 == 0) {
                answer[index++] = number / 2;
            } else if (number < 50 && number % 2 == 1) {
                answer[index++] = number * 2;
            } else {
                answer[index++] = number;
            }
        }
        
        return answer;
    }
}