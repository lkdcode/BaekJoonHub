import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        	int[] answer = new int[commands.length];

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < commands.length; i++) {
			int x = commands[i][0];
			int y = commands[i][1];
			int z = commands[i][2];
			for (; x <= y; x++) {
				arr.add(array[x - 1]);
			}
			Collections.sort(arr);
			answer[i] = arr.get(z - 1);
			arr.clear();
		}
        return answer;
    }
}