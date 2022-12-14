import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int inputNumber = Integer.parseInt(bf.readLine());

        int result = 1;
        for (int i = inputNumber; i > 0; i--) {
            result *= i;
        }

        System.out.println(result);

    }
}