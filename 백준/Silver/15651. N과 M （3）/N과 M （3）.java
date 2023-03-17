import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static int[] result;

    private static StringBuilder print = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numbers = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        result = new int[size];
        /**
         * 1 2 3 4
         * 1 1 1 1
         * 1 1 1 2
         */

        DFS(numbers, size, 0);
        System.out.println(print);
    }

    private static void DFS(int numbers, int size, int depth) {
        if (size == depth) {
            for (int view : result) {
                print.append(view)
                        .append(" ");
            }
            print.append("\n");
            return;
        }

        for (int i = 0; i < numbers; i++) {
            result[depth] = i + 1;
            DFS(numbers, size, depth + 1);
        }

    }
}
