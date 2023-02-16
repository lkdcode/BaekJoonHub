import java.io.IOException;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();

            System.out.println((firstNumber * secondNumber) / GCD(firstNumber, secondNumber));
        }
    }

    private static int GCD(int firstNumber, int secondNumber) {
        if (firstNumber % secondNumber == 0) {
            return secondNumber;
        }
        return GCD(secondNumber, firstNumber % secondNumber);
    }
}
