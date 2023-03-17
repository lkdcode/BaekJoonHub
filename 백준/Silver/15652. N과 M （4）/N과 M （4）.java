import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder result = new StringBuilder();
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberSize = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        numbers = new int[numberSize];

        DFS(0, numberSize, size, 0);

        System.out.print(result);
    }

    private static void DFS(int minIndex, int numberSize, int size, int depth) {
        if (size == depth) {
            for (int input : numbers) {
                if (input != 0) {
                    result.append(input)
                            .append(" ");
                }
            }
            result.append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < numberSize; i++) {
            int inputNumber = i + 1;

            if (minIndex <= inputNumber) {
                numbers[depth] = inputNumber;
                DFS(inputNumber, numberSize, size, depth + 1);
            }

        }

    }
}
