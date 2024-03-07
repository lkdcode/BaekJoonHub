import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int size = friends.length;

        int[][] point = new int[size][size];
        Map<String, Integer> userIndex = new HashMap<>();

        int index = 0;
        for (String friend : friends) {
            userIndex.put(friend, index++);
        }

        for (String gift : gifts) {
            String[] g = gift.split(" ");
            int giveIndex = userIndex.get(g[0]);
            int receiveIndex = userIndex.get(g[1]);

            point[giveIndex][receiveIndex]++;
        }

        Map<String, Integer> giftPoint = new HashMap<>();

        //
        for (String name : friends) {
            int i = userIndex.get(name);

            int givePoint = 0;
            int receivePoint = 0;

            for (int j = 0; j < size; j++) {
                givePoint += point[i][j];
                receivePoint += point[j][i];
            }
            giftPoint.put(name, givePoint - receivePoint);
        }

        int answer = 0;

        for (String name : friends) {
            int i = userIndex.get(name);

            int gift = 0;

            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                if (point[i][j] > point[j][i]) {
                    gift++;
                    continue;
                }
                if (point[i][j] == point[j][i] ||
                        (point[i][j] == 0 && point[j][i] == 0)) {
                    int giveUserGiftPoint = giftPoint.get(name);
                    int receiveUserGiftPoint = giftPoint.get(friends[j]);
                    if (giveUserGiftPoint > receiveUserGiftPoint) {
                        gift++;
                    }
                }
            }

            answer = Math.max(gift, answer);
        }
        return answer;
    }
}