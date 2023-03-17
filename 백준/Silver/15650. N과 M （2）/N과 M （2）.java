import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static int[] result;
    private static List<String> printResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numbers = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        visited = new boolean[numbers];
        result = new int[numbers];

        DFS(numbers, size, 0);


        for (int i = 0; i < printResult.size(); i++) {
            String result = printResult.get(i);
            for (int j = 0; j < result.length(); j++) {
                System.out.print(result.charAt(j) + " ");
            }
            System.out.println();

        }


    }

    private static void DFS(int numbers, int size, int depth) {

        if (size == depth) {

            int[] copyResult = result.clone();

            Arrays.sort(copyResult);
            String inputNumber = "";
            for (int number : copyResult) {
                if (number != 0) {
                    inputNumber += number;
                }
            }

            if (!printResult.contains(inputNumber)) {
                printResult.add(inputNumber);
            }
            return;
        }

        for (int i = 0; i < numbers; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;

                DFS(numbers, size, depth + 1);
                visited[i] = false;
            }
        }
    }
}
