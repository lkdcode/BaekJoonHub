import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true) {
            int number = Integer.parseInt(br.readLine());

            if (number == -1) {
                return;
            }

            List<Integer> list = new ArrayList<>();

            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    list.add(i);
                }
            }

            int sum = 0;

            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }

            if (sum == number) {
                StringBuilder result = new StringBuilder();

                result.append(number)
                        .append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    result.append(list.get(i));
                    if (i < list.size() - 1) {
                        result.append(" + ");
                    }

                }
                System.out.println(result);

            } else {
                System.out.println(number + " is NOT perfect.");
            }


        }
    }
}
