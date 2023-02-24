import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int endIndex = scanner.nextInt();

        int[] temp = new int[size];

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            temp[i] = scanner.nextInt();
        }


        for (int i = 0; i <= size - endIndex; i++) {
            int sum = 0;

            for (int j = i; j < i + endIndex; j++) {
                sum += temp[j];
            }

            result = Math.max(sum, result);

        }

        System.out.println(result);

    }
}
