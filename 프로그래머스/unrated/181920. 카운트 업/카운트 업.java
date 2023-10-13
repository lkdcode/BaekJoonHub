class Solution {
    public int[] solution(int start_num, int end_num) {
        int size = end_num - start_num;
        int[] answer = new int[size + 1];
        int index = 0;
        for (int i = start_num; i <= end_num; i++) {
            answer[index++] = i;
        }
        
        return answer;
    }
}