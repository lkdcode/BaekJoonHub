import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int student1AnswerCount = 0;
        int student2AnswerCount = 0;
        int student3AnswerCount = 0;
        
        int student1AnswerCountIndex = 0;
        int student2AnswerCountIndex = 0;
        int student3AnswerCountIndex = 0;
        
        int maxCount = 0;
        
        for (int check : answers) {
            
            if (student1[student1AnswerCountIndex++] == check) {
                student1AnswerCount++;
            }
            
            if (student2[student2AnswerCountIndex++] == check) {
                student2AnswerCount++;
            }
            
            if (student3[student3AnswerCountIndex++] == check) {
                student3AnswerCount++;
            }
            
            maxCount = Math.max(student3AnswerCount, Math.max(student1AnswerCount, student2AnswerCount));
            
            if (student1AnswerCountIndex >= student1.length) student1AnswerCountIndex = 0;
            if (student2AnswerCountIndex >= student2.length) student2AnswerCountIndex = 0;
            if (student3AnswerCountIndex >= student3.length) student3AnswerCountIndex = 0;
        }
            
        List<Integer> list = new ArrayList<>();
        
        if (maxCount == student1AnswerCount) {    
            list.add(1);
        }
        
        if (maxCount == student2AnswerCount) { 
            list.add(2);
        }
        
        if (maxCount == student3AnswerCount) {
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        
        int index = 0;
        
        for (int i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}