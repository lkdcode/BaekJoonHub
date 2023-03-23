class Solution {
    public int solution(int num, int k) {
            String number = String.valueOf(num);
        int answer = -1;

        for (int i = 0; i < number.length(); i++) {
            if (Integer.parseInt(String.valueOf(number.charAt(i))) == k) {
                answer = i + 1;break;
        
            }
        }
        return answer;
    }
}