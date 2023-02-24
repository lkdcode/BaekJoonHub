import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int step = Integer.parseInt(input[1]);

        Deque<Integer> numbers = new ArrayDeque<>();


        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while (!numbers.isEmpty()) {
            for (int i = 1; i < step; i++) {
                numbers.add(numbers.pollFirst());
            }
            result.append(numbers.pollFirst());
            if (!numbers.isEmpty()) {
                result.append(", ");
            }
        }
        result.append(">");
        System.out.println(result);
    }
}
