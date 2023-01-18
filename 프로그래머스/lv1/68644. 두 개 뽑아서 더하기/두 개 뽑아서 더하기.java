import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//public class Programmers68644 {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] numbers = {2, 1, 3, 4, 1};
//        solution.solution(numbers);
//    }
//}

/**
 * logic
 * 1. 입력받은 배열의 값을 하나씩 꺼내서 더하고 List에 추가한다.
 * 2. 더해준 값의 중복을 제거한다.
 * 3. 배열을 오름차순으로 정렬한다.
 * 3. 정답 배열을 리턴해준다.
 */
class Solution {
    public int[] solution(int[] numbers) {
        //1. 입력받은 배열의 값을 하나씩 꺼내서 더하고 List에 추가한다.
        List<Integer> addList = calculator(numbers);

        //2. 더해준 값의 중복을 제거한다.
        addList = duplicateDelete(addList);

        //3. 배열을 오름차순으로 정렬한다.
        addList = sortList(addList);

        //4. 정답 배열을 리턴해준다.
        return result(addList);
    }

    private List<Integer> calculator(int[] numbers) {
        List<Integer> addList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                addList.add(numbers[i] + numbers[j]);
            }
        }

        return addList;
    }

    private List<Integer> duplicateDelete(List<Integer> addList) {
        List<Integer> duplicateDeleteList = new ArrayList<>();

        for (int i = 0; i < addList.size(); i++) {
            if (!duplicateDeleteList.contains(addList.get(i))) {
                duplicateDeleteList.add(addList.get(i));
            }
        }

        return duplicateDeleteList;
    }

    private List<Integer> sortList(List<Integer> addList) {
        Collections.sort(addList);
        return addList;
    }

    private int[] result(List<Integer> addList) {
        int[] result = new int[addList.size()];
        for (int i = 0; i < addList.size(); i++) {
            result[i] = addList.get(i);
        }
        return result;
    }
}
