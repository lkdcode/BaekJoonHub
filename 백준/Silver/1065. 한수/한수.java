import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// class Main으로 수정
public class Main {
    private static final BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int number = Integer.parseInt(BF.readLine());

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (i < 100) {
                count++;
                continue;
            }
            if (check(i)) {
                count++;
            }

        }
        System.out.println(count);

    }

    private static boolean check(int i) {
        List<Integer> numbers = new ArrayList<>();
        String str = String.valueOf(i);

        for (int j = 0; j < str.length(); j++) {
            numbers.add(Integer.parseInt(String.valueOf(str.charAt(j))));
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < numbers.size() - 1; j++) {
            int num = numbers.get(j) - numbers.get(j + 1);
            result.add(num);
        }

        for (int j = 0; j < result.size() - 1; j++) {
            if (!(result.get(j) == result.get(j + 1))) {
                return false;
            }
        }

        return true;
    }
}