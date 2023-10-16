import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            student[i] = 1;
        }
        
        
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i]]++;
        }
        
        for (int i = 0; i < lost.length; i++) {
            student[lost[i]]--;
        }
        
        System.out.println(Arrays.toString(student) + " < < < ");
        
        for (int i = 1; i < student.length; i++) {
            if (student[i] == 2) {
                
                if (i - 1 >= 1 && student[i - 1] == 0) {
                    student[i - 1]++;
                    student[i]--;
                    continue;
                }
                
                if (i + 1 < student.length && student[i + 1] == 0) {
                    student[i + 1]++;
                    student[i]--;
                    continue;
                }
            }
        }
        
        System.out.println(Arrays.toString(student) + " < < < ");
        
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 1) answer++;
        }
    
        return answer;
    }
}