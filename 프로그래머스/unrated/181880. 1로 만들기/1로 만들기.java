class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for (int number : num_list) {
            
            while (number != 1) {
                if (number % 2 == 0) {
                  number /= 2;  
                } else {
                    number--;
                    number /= 2;
                }
                answer++;
            }
                
        }
        
        return answer;
    }
}