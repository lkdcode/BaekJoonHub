import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
    Stack<Integer> stack = new Stack<>();

        for (int number : ingredient) {
            stack.push(number);

            if (stack.size() >= 4) {
                int bread2 = stack.pop(); // 1
                int meet = stack.pop(); // 3
                int vegetable = stack.pop(); // 2
                int bread1 = stack.pop(); // 1

                if (bread2 == 1
                        && meet == 3
                        && vegetable == 2
                        && bread1 == 1) {
                    answer++;
                } else {
                    stack.push(bread1);
                    stack.push(vegetable);
                    stack.push(meet);
                    stack.push(bread2);
                }
            }
        }
        return answer;
    }
}