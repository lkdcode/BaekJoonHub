import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        int a = slicer[0];
        int b = slicer[1] + 1;
        int c = slicer[2];
        
        switch(n) {
            case 1:
                answer = Arrays.copyOfRange(num_list, 0, b);
                break;
            case 2:
                answer = Arrays.copyOfRange(num_list, a, num_list.length);
                break;
            case 3:
                answer = Arrays.copyOfRange(num_list, a, b);
                break;
            case 4:
                for (int i = a; i < b; i += c) {
                    list.add(num_list[i]);
                }
                answer = list.stream().mapToInt(Integer::intValue).toArray();
                break;
        }
        
        return answer;
    }
}