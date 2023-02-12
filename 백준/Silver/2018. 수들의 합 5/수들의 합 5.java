import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int startIndex = 1;
        int endIndex = 1;
        int result = 1;
        int sum = 1;

        // sum > number  ->  sum - startIndex; startIndex++;
        // sum < number  ->  endIndex++; sum += endIndex;
        // sum == number -> result++ , endIndex++; sum += endIndex;

        while (endIndex != number) {
            if (sum == number) {
                result++;
                endIndex++;
                sum += endIndex;
            } else if (sum < number) {
                endIndex++;
                sum += endIndex;
            } else {
                sum -= startIndex;
                startIndex++;
            }
        }

        System.out.println(result);

    }
}
