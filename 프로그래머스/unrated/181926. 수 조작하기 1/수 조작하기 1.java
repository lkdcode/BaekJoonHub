class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        for (int i = 0; i < control.length(); i++) {
            char check = control.charAt(i);
            
            if (check == 'w') {
                answer += 1;
            }
            if (check == 's') {
                answer -= 1;
            }
            if (check == 'd') {
                answer += 10;
            }
            if (check == 'a') {
                answer -= 10;
            }
        }
        
        return answer;
    }
}