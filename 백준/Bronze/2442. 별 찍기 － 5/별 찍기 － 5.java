import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int input = scanner.nextInt();

        int blankLoop = 1;

        for (int i = 1; i <= input; i++) {
            int loop = 2 * i - 1;

            for (int j = blankLoop; j < input; j++) {
                System.out.print(" ");
            }

            blankLoop++;

            for (int j = loop; j > 0; j--) {
                System.out.print("*");
            }

            if (i != input) {
                System.out.println();
            }

        }

    }
}
