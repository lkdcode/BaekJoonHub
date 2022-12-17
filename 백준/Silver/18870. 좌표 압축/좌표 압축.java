import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[] NUMBERS;
    private static int[] NUMBERS_COPY;
    private static final HashMap<Integer, Integer> STEP_NUMBERS = new HashMap<>();
    private static int SIZE;

    public static void main(String[] args) throws IOException {
        input();
        String[] input = bf.readLine().split(" ");

        // 번호를 입력 받아서 리스트로 생성
        // 복사본은 정렬
        makeNumbers(input);

        // 키와 밸류로 HashMap 생성
        makeKey();

        // 결과 출력
        printResult();
    }

    private static void input() throws IOException {
        SIZE = Integer.parseInt(bf.readLine());

        NUMBERS = new int[SIZE];
        NUMBERS_COPY = NUMBERS.clone();
    }

    private static void makeNumbers(String[] input) {
        for (int i = 0; i < SIZE; i++) {
            NUMBERS[i] = NUMBERS_COPY[i] = (Integer.parseInt(input[i]));
        }
        Arrays.sort(NUMBERS_COPY);
    }

    private static void makeKey() {
        int index = 0;
        for (int i = 0; i < NUMBERS_COPY.length; i++) {
            if (!STEP_NUMBERS.containsKey(NUMBERS_COPY[i])) {
                STEP_NUMBERS.put(NUMBERS_COPY[i], index);
                index++;
            }
        }


    }

    private static void printResult() {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < NUMBERS.length; i++) {
            answer.append(STEP_NUMBERS.get(NUMBERS[i]));
            if (i != NUMBERS.length - 1) {
                answer.append(' ');
            }
        }
        System.out.println(answer);
    }

}