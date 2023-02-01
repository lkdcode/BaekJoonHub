import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static final Solution baekJoon11720 = new Solution();

    /**
     * ---------------------
     * BaekJoon11720 logic
     * ---------------------
     * <p>
     * 1. 숫자의 갯수 입력받기 -> int size
     * 1-1) 1~100 유효성 검사, @Test Exception, message
     * 2. 공백없는 숫자 입력받기 -> String numbers
     * 2-1) 숫자의 갯수와 문자열의 길이 유효성 검사, @Test Exception, message
     * 3. 하나씩 잘라서 결과 값에 더하기 -> makeResult();
     * 3-1) @Test 문자열을 숫자로 바꾼 총 합계
     * 4. 결과 출력 -> int result
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int size = baekJoon11720.inputSize();

        String numbers = baekJoon11720.inputNumbers(size);

        int result = baekJoon11720.makeResult(numbers);

        baekJoon11720.printResult(result);
    }


}

class SolutionValidate {
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 100;
    private static final String ERROR_SIZE = "[ERROR] 입력 가능한 숫자 범위는 1에서 100사이입니다.";
    private static final String ERROR_NUMBERS_SIZE = "[ERROR] 입력한 숫자의 갯수가 다릅니다.";

    /**
     * 숫자의 사이즈 1 ~ 100 범위인지 유효성 검사
     *
     * @param size 숫자의 갯수
     */
    public void validateSize(int size) {
        if (!(size >= MIN_SIZE && size <= MAX_SIZE)) {
            throw new NumberFormatException(ERROR_SIZE);
        }
    }

    /**
     * 숫자의 사이즈와 공백없이 이루어진 문자열의 길이가 같은지 유효성 검사
     *
     * @param size    숫자의 갯수
     * @param numbers 공백없이 이루어진 문자열
     */
    public void validateNumbers(int size, String numbers) {
        if (size != numbers.length()) {
            throw new NumberFormatException(ERROR_NUMBERS_SIZE);
        }
    }
}

class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final SolutionValidate validate = new SolutionValidate();

    /**
     * 숫자의 갯수를 입력받는 메소드
     *
     * @return 유효성 검사를 마친 후 리턴
     * @throws IOException
     */
    public int inputSize() throws IOException {
        int size = Integer.parseInt(br.readLine());
        validate.validateSize(size);
        return size;
    }


    /**
     * 공백없이 이루어진 숫자를 입력받는 메소드
     *
     * @param size
     * @return 유효성 검사를 마친 후 리턴
     * @throws IOException
     */
    public String inputNumbers(int size) throws IOException {
        String numbers = br.readLine();
        validate.validateNumbers(size, numbers);
        return numbers;
    }


    /**
     * String 타입의 문자를 하나씩 잘라서 int 타입으로 형변환을 하고 int result 변수에 담는 메소드
     *
     * @param numbers
     * @return
     */
    public int makeResult(String numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length(); i++) {
            result += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        return result;
    }

    /**
     * 정답을 출력하는 메소드
     *
     * @param result
     */
    public void printResult(int result) {
        System.out.println(result);
    }
}
