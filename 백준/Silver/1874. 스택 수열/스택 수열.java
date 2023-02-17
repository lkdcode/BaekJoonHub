import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int size = scanner.nextInt();
        int[] A = new int[size];

        for (int i = 0; i < size; i++) {
            A[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        int count = 1;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int number = A[i];

            if (number >= count) {
                while (number >= count) {
                    stack.push(count++);
                    stringBuilder.append("+\n");
                }
                stack.pop();
                stringBuilder.append("-\n");
            } else {
                int stackNumber = stack.pop();
                if (number < stackNumber) {
                    System.out.println("NO");
                    return;
                } else {
                    stringBuilder.append("-\n");
                }
            }

        }

        System.out.println(stringBuilder);

    }
}
