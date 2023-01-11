class Solution {
    public int solution(String A, String B) {
        String str = A;
        int answer = -1;

        for (int i = 0; i < A.length(); i++) {
            str = A;
            if (str.equals(B)) {
                answer = i;
                break;
            }
            A = str.substring(str.length() - 1);
            A += str.substring(0, str.length() - 1);
        }
        return answer;
    }
}