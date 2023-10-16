import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6, 6};

        int same = 0;
        int joker = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) same++;
            }
            if (lottos[i] == 0) joker++;
        }

        if (same + joker == 6) answer[0] = 1;
        if (same + joker == 5) answer[0] = 2;
        if (same + joker == 4) answer[0] = 3;
        if (same + joker == 3) answer[0] = 4;
        if (same + joker == 2) answer[0] = 5;
        if (same + joker <= 1) answer[0] = 6;
        
        if (same == 6) answer[1] = 1;
        if (same == 5) answer[1] = 2;
        if (same == 4) answer[1] = 3;
        if (same == 3) answer[1] = 4;
        if (same == 2) answer[1] = 5;
        if (same <= 1) answer[1] = 6;
        
        return answer;
    }
}