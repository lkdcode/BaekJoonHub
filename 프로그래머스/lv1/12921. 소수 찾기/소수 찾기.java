class Solution {
    public int solution(int n) {
        int answer = 0;
        		int[] arr = new int[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = 0;
		}
    
        int root = (int) Math.sqrt(n);
		for (int i = 2; i <= root; i++) {
			if (arr[i] == 0) {
				for (int j = i; j * i <= n; j++) {
					arr[i * j] = 1;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				answer++;
			}
		}
        return answer;
    }
}