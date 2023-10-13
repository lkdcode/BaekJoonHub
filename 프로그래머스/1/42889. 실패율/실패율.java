import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int playerSize = stages.length;
        
        int[] stagesCheck = new int[N + 2];
        
        for (int stage : stages) {
            stagesCheck[stage]++;
        }
        
        double[] failureRate = new double[N + 2];
        
        for (int i = 1; i < stagesCheck.length; i++) {
            if (stagesCheck[i] == 0) {
                failureRate[i] = 0;
            } else {
                failureRate[i] = (double) stagesCheck[i] / playerSize;
            }
            
            playerSize -= stagesCheck[i];
        }
        
        double[] check = Arrays.copyOf(failureRate, failureRate.length);
        
        Arrays.sort(failureRate);
        int index = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = failureRate.length - 1; i >= 0; i--) {
            for (int j = 1; j < check.length - 1; j++) {
                if (failureRate[i] == check[j]) {
                    // answer[index++] = j;
                    if (list.contains(j)) continue;
                    list.add(j);
                }
            }
        }
    
        // System.out.println(list);
        answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}