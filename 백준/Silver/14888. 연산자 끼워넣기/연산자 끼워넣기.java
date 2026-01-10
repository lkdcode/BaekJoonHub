
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int size = 0;
    private static int MIN_RESULT = Integer.MAX_VALUE;
    private static int MAX_RESULT = Integer.MIN_VALUE;
    private static int[] numbers;
    private static final int[] operations = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        numbers = new int[size];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(MAX_RESULT);
        System.out.println(MIN_RESULT);
    }

    private static void dfs(int number, int depth) {
        if (depth == size) {
            MAX_RESULT = Integer.max(number, MAX_RESULT);
            MIN_RESULT = Integer.min(number, MIN_RESULT);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operations[i] > 0) {
                operations[i]--;

                switch (i) {
                    case 0:
                        dfs(number + numbers[depth], depth + 1);
                        break;
                    case 1:
                        dfs(number - numbers[depth], depth + 1);
                        break;
                    case 2:
                        dfs(number * numbers[depth], depth + 1);
                        break;
                    case 3:
                        dfs(number / numbers[depth], depth + 1);
                        break;
                }

                operations[i]++;
            }
        }
    }
}