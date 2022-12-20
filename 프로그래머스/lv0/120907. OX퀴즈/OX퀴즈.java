import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
List<String> input = new ArrayList<>();
        String add = "";
        for (String inputs : quiz) {
            add = inputs;
            String[] split = add.split(" ");
            for (String addWord : split) {
                input.add(addWord);
            }
        }
        // 문자 쪼개서 1글자씩 리스트에 추가

        List<String> result = new ArrayList<>();

        for (int i = 0; i < input.size(); i += 5) {
            int firstNumber = Integer.parseInt(input.get(i));
            int secondNumber = Integer.parseInt(input.get(i + 2));
            int answer = Integer.parseInt(input.get(i + 4));

            if (input.get(i + 1).equals("-")) {
                if (firstNumber - secondNumber == answer) {
                    result.add("O");
                    continue;
                }
            }

            if (input.get(i + 1).equals("+")) {
                if (firstNumber + secondNumber == answer) {
                    result.add("O");
                    continue;
                }
            }

            result.add("X");
        }

        String[] answer = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}