import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                String key = String.valueOf(keymap[i].charAt(j));
                
                if (map.get(key) == null) map.put(key, j + 1);
                else map.put(key, Math.min(j + 1, map.get(key)));
            }
        }
        
        w:
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            

            for (int j = 0; j < targets[i].length(); j++) {
                String check = String.valueOf(targets[i].charAt(j));
               
                if (!map.containsKey(check)) {
                    list.add(-1);
                    continue w;
                }
                
                sum += map.get(check);
            }
            
            if (sum != 0) list.add(sum);
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}