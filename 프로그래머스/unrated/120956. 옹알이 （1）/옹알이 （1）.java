import java.util.*;

class Solution {
    
     public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
                answer++;
            }
        }
        return answer;
    }
    
}