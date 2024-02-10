import java.util.*;

class Solution {
    
    private static final Map<String, Integer> map = Map.of(
            "code", 0,
            "date", 1,
            "maximum", 2,
            "remain", 3
    );

    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
     List<int[]> result = new ArrayList<>();

        for (int[] datum : data) {
            final int targetIndex = map.get(ext);

            if (datum[targetIndex] < val_ext) {
                result.add(datum);
            }
        }

        result.sort(Comparator.comparing(e -> e[map.get(sort_by)]));

        int[][] answer = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            answer[i][0] = result.get(i)[0];
            answer[i][1] = result.get(i)[1];
            answer[i][2] = result.get(i)[2];
            answer[i][3] = result.get(i)[3];
        }
        
        return answer;
    }
}