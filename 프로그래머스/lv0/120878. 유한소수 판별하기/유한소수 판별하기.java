class Solution {
    public int solution(int a, int b) {
      
        int num = b / gcd(a, b);

        for (int i = 0; i < b; i++) {
            if (num % 2 == 0) {
                num /= 2;
            }
            if (num % 5 == 0) {
                num /= 5;
            }
        }

        int answer = 2;
        if (num == 1) {
            answer = 1;
        }
        return answer;
    }
    
    
    static int gcd(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
 
    
    
}