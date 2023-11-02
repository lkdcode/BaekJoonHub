class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for (int i = 0; i < my_string.length(); i++) {
            char check = my_string.charAt(i);

            if (check - 0 >= 65 && check - 0 <= 90) {
                answer[(check - 0) - 65]++;
            }
            if (check - 0 >= 97 && check - 0 <= 122) {
                answer[(check - 0) - 97 + 26]++;
            }
        }
        
        return answer;
    }
}