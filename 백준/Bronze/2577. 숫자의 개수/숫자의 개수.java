import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        int[] allNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new int[10];

        int number = a * b * c;
        while (number > 0) {
            int digit = number % 10;
            for (int i = 0; i < allNumbers.length; i++) {
                if (digit == allNumbers[i]) {
                    result[i]++;
                }
            }
            number /= 10;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}