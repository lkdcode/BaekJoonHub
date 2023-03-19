import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numbers);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> minusNumbers = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            int number = numbers.get(i + 1) - numbers.get(i);
            queue.offer(number);
            minusNumbers.add(number);
        }

        int loop = queue.size() - 1;

        for (int i = 0; i < loop; i++) {
            queue.offer(GCD(queue.poll(), queue.poll()));
        }


        int gcd = queue.poll();
        int result = 0;


        for (int i = 0; i < minusNumbers.size(); i++) {
            result += minusNumbers.get(i) / gcd - 1;
        }

        System.out.println(result);
    }


    private static int GCD(int firstNumber, int secondNumber) {
        return secondNumber == 0 ? firstNumber : GCD(secondNumber, firstNumber % secondNumber);
    }


}
