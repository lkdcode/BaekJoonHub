import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] sortedPriorities = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sortedPriorities);
        int sortedIndex = sortedPriorities.length - 1;

        final Queue<Integer> prioritiesQueue = new LinkedList<>();
        final Queue<Integer> indexQueue = new LinkedList<>();
        int index = 0;

        for (int number : priorities) {
            prioritiesQueue.add(number);
            indexQueue.add(index++);
        }

        while (true) {
            final int target = sortedPriorities[sortedIndex];
            if (prioritiesQueue.peek() == target) {
                if (indexQueue.peek() == location) {
                    return sortedPriorities.length - sortedIndex;
                }
                sortedIndex--;
                prioritiesQueue.poll();
                indexQueue.poll();

                continue;
            }

            prioritiesQueue.add(prioritiesQueue.poll());
            indexQueue.add(indexQueue.poll());
        }
    }
}