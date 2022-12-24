class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        //두 수의 최대공약수 
        int gcd = gcd(a,b);
        int gb = b / gcd;

         for (int i = 2; i <= gb; i++) {
            while (gb % i == 0) {
                if (i == 2 || i == 5) {
                    gb /= i;
                    //continue;
                } else {
                    break;
                }
            }
        }

        answer = 2;
        if (gb == 1) {
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