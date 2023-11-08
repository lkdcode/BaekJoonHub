import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        String[] answer = players;
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String name : callings) {
            // System.out.println(Arrays.toString(answer));
            int playerRank = map.get(name);
            
            int prePlayerRank = playerRank - 1;
            String prePlayerName = answer[prePlayerRank];
            
            answer[prePlayerRank] = name;
            answer[playerRank] = prePlayerName;
            
            map.put(name, prePlayerRank);
            map.put(prePlayerName, playerRank);
        }
        
        return answer;
    }
}