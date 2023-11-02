import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            int index = Integer.MAX_VALUE;
            for (int j = s; j <= e; j++) {
                if (k < arr[j]) {
                    index = Math.min(arr[j], index);
                }
            }
            if (index == Integer.MAX_VALUE) {
                list.add(-1);
            } else {
                list.add(index);
            }
            
        }
        
        System.out.println(list);
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}