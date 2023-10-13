class Solution {
    public int[] solution(int start, int end_num) {
        int size = start - end_num;
        
        int[] answer = new int[size + 1];
        int index = 0;
        for (int i = start; i >= end_num; i--) {
            answer[index++] = i;
        }
        
        return answer;
    }
}