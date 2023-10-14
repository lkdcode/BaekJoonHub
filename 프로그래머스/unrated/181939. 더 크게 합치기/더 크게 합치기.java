class Solution {
    public int solution(int a1, int b1) {
        String a = "" + a1 + b1;
        String b = "" + b1 + a1;        
        
        return Math.max(Integer.parseInt(a), Integer.parseInt(b));
    }
}