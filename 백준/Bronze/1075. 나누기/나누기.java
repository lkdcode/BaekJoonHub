import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int firstNumber = Integer.parseInt(bf.readLine());
        int secondNumber = Integer.parseInt(bf.readLine());

        firstNumber = (firstNumber / 100) * 100;
        String result = "";

        for (int i = 0; i < 100; i++) {
            int number = firstNumber + i;
            if (number % secondNumber == 0) {
                result = String.valueOf(i);
                break;
            }
        }
        if (result.length() == 1) {
            System.out.println("0" + result);
            return;
        }

        System.out.println(result);


    }
}