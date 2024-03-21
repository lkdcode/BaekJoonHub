import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(true) {
            if (n % 2 != 0) ans++;
            if (n < 1) break;
            n /= 2;
        }

        return ans;
    }
}