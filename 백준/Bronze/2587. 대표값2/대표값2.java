import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int add = Integer.parseInt(bf.readLine());
            numbers.add(add);
        }

        Collections.sort(numbers);
        int result2 = numbers.get(2);

        int result1 = 0;
        for (int i = 0; i < numbers.size(); i++) {
            result1 += numbers.get(i);
        }

        result1 /= 5;

        System.out.println(result1);
        System.out.println(result2);


    }
}