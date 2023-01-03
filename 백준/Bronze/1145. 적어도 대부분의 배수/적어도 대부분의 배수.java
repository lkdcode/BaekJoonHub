import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputSplit = input.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String add : inputSplit) {
            numbers.add(Integer.parseInt(add));
        }
        Collections.sort(numbers);
        // 입력 받은 값을 리스트로 변환하여 솔팅한다.
        // 카운트와 가장 작은 수를 선언해주고
        // 카운트가 3 이상 나올 때까지 반복문을 돌아준다
        // 입력값의 예시는 1,2,3,4,5
        // 1 % 2 .. 1 % 3 .. 1 % 4 .. 1 % 5 ..
        // 의 값이 0과 같다면 count++ 해주고
        // count가 3미만이면 minNumber 를 ++ 해준다
        // 이렇게 카운트가 3이 될 때까지 minNumber 가 1씩 증가하면서
        // 최소3개의 배수를 찾게된다.
        int minNumber = numbers.get(0);
        int count = 0;
        while (true) {
            for (int i = 0; i < numbers.size(); i++) {
                if (minNumber % numbers.get(i) == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                System.out.println(minNumber);
                return;
            }
            count = 0;
            minNumber++;
        }

    }
}
