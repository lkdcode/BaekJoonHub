import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int n : score) {
            pq.add(n);
        }
        
        int size = pq.size();
        
        while ((size -= m) >= 0) {
            
            for (int i = 1; i < m; i++) {
                pq.poll();
            }
            
            int nq = pq.poll();
            
            answer += nq * m;
        }
        
        return answer;
    }
}