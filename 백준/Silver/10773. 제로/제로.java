import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < size; i++) {
            int inputNumber = Integer.parseInt(br.readLine());
            if (inputNumber != 0) {
                numbers.push(inputNumber);
            } else {
                numbers.pop();
            }
        }
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            result += numbers.get(i);
        }
        System.out.println(result);
    }
}
