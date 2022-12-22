import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int input = Integer.parseInt(bf.readLine());

        int result = 0;
        for (int i = 1; i <= input; i++) {
            int number = i;
            number += make(number);
            if (number == input) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }

    private static int make(int number) {
        String length = String.valueOf(number);

        int forNumber = 0;
        for (int i = 0; i < length.length(); i++) {
            forNumber += number % 10;
            number /= 10;
        }

        return forNumber;
    }
}