import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");

        int result = 0;

        for (int i = 0; i < size; i++) {
            if (isPrime(Integer.parseInt(inputSplit[i]))) {
                result++;
            }
        }

        System.out.println(result);

    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {

            if (number % i == 0) {
                return false;
            }

        }

        return true;
    }
}