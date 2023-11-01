class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        
        for (int i = 0; i < queries.length; i++) {
            int firstIndex = queries[i][0];
            int secondIndex = queries[i][1];
            
            int temp = answer[firstIndex];
            answer[firstIndex] = arr[secondIndex];
            answer[secondIndex] = temp;
        }
        
        return answer;
    }
}