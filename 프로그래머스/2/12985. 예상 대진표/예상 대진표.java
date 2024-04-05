class Solution {
   public int solution(int n, int a, int b) {
        int count = 1;
        
        while (true) {
            if ((a % 2 == 0 && b + 1 == a)
                ||(b % 2 == 0 && a + 1 == b)) {
                return count;
            }

            count++;

            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a = a / 2 + 1;
            }

            if (b % 2 == 0) {
                b = b / 2;
            } else {
                b = b / 2 + 1;
            }
        }
    }
}