class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        boolean[] wall = new boolean[n + 1];
        
        for (int part : section) {
            if (wall[part]) continue;
            
            for (int i = part; i < part + m; i++) {
                if (i > n) break;
                wall[i] = true;
            }

            answer++;
        }
        
        return answer;
    }
}