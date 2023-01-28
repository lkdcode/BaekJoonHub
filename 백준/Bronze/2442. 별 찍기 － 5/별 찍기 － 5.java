import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int input = scanner.nextInt();

        int k = 0;

        for (int i = 1; i <= input; i++) {
            int loop = 2 * i - 1;

            for (int j = k; j < input - 1; j++) {
                System.out.print(" ");
            }

            k++;

            for (int j = loop; j > 0; j--) {
                System.out.print("*");
            }

            if (i != input) {
                System.out.println();
            }

        }

    }
}
