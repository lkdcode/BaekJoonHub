import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            int remainingProgress = 100 - progress;
            int needProgress = remainingProgress / speed;

            if (remainingProgress % speed != 0) {
                needProgress++;
            }
            queue.add(needProgress);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int day = queue.poll();
            int deployDay = 1;
            while (!queue.isEmpty() && queue.peek() <= day) {
                queue.poll();
                deployDay++;
            }
            result.add(deployDay);
        }
        
        return result.stream()
                .mapToInt(e -> e)
                .toArray();
    }
}