import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] rank = new double[score.length];
        List<Double> list = new ArrayList<>();
        
        for (int i = 0; i < rank.length; i++) {
            rank[i] = (score[i][0] + score[i][1]) / 2.0;    
            if (!list.contains(rank[i])) {
                list.add(rank[i]);
            }
        }
                
        Collections.sort(list, Collections.reverseOrder());
        
        int rankIndex = 1;
        
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < rank.length; j++) {
                if (list.get(i) == rank[j]) {
                    answer[j] = rankIndex;
                    count++;
                }
            }
            rankIndex += count;
        }
        
        return answer;
    }
}