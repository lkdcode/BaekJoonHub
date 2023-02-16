import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();


        while (firstNumber != 0 && secondNumber != 0) {

            if (secondNumber % firstNumber == 0) {
                System.out.println("factor");
            } else if (firstNumber % secondNumber == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }

            firstNumber = scanner.nextInt();
            secondNumber = scanner.nextInt();
        }
    }
}
