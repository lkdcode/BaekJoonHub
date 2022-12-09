import java.util.Scanner;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {

        int inputSize = SCAN.nextInt();

        String[] inputNumber = SCAN.next().split("");
        int result = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            result += Integer.parseInt(inputNumber[i]);
        }

        System.out.println(result);

    }
}