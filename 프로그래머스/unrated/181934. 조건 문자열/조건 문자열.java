class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        ineq += eq;
        
        switch (ineq) {
            case "<=" :
                if (n <= m) return 1;
                return 0;
            case "<!" :
                if (n < m) return 1;
                return 0;
            case ">=" :
                if (n >= m) return 1;
                return 0;
            case ">!" :
                if (n > m) return 1;
                return 0;
        }
        
        return answer;
    }
}