import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());


        for (int i = 0; i < size; i++) {
            Queue<Integer> numbers = new LinkedList<>();
            Queue<Integer> important = new LinkedList<>();

            List<Integer> checkList = new ArrayList<>();

            String[] input = br.readLine().split(" ");

            int find = 0;
            // 0번부터 시작하는 큐 생성
            for (int j = 0; j < Integer.parseInt(input[0]); j++) {
                numbers.add(j);
                if (Integer.parseInt(input[1]) == j) {
                    // 몇번째로 출력되는지 궁금한 숫자
                    find = j;
                }
            }

            input = br.readLine().split(" ");

            // 중요도를 큐와 리스트에 담는다
            for (int j = 0; j < input.length; j++) {
                important.add(Integer.parseInt(input[j]));
                checkList.add(Integer.parseInt(input[j]));
            }

            // 찾아야할 중요도를 정렬한다
            Collections.sort(checkList, Collections.reverseOrder());


            // 출력 횟수 카운트하기
            int count = 0;


            for (int j = 0; j < checkList.size(); j++) {
                int checkNumber = checkList.get(j);

                int number = 0;
                int importantNumber = 0;

                while (true) {

                    number = numbers.poll();
                    importantNumber = important.poll();

                    if (importantNumber == checkNumber) {
                        count++;
                        break;
                    } else {
                        numbers.add(number);
                        important.add(importantNumber);
                    }
                }

                if (find == number) {
                    System.out.println(count);
                    break;
                }

            }

        }
    }
}