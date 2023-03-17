import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        // TODO : 다시 풀기

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numbers = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        visited = new boolean[numbers];
        result = new int[numbers];

        DFS(numbers, size, 0);

    }

    private static void DFS(int numbers, int size, int depth) {
        if (size == depth) {
            for (int number : result) {
                if (number != 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

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
