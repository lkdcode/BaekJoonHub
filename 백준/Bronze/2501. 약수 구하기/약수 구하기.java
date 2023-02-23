import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int number = Integer.parseInt(input[0]);
        int find = Integer.parseInt(input[1]);

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                numbers.add(i);
            }
        }
        try {
            System.out.println(numbers.get(find - 1));
        } catch (Exception e) {
            System.out.println("0");
        }
    }
}
