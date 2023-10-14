class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            String check = String.valueOf(my_string.charAt(i));
            if (check.equals(alp)) {
                answer += check.toUpperCase();
            } else {
                answer += check;
            }
        }
        return answer;
    }
}