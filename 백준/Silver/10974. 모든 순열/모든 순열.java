import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        result = new int[size];
        visited = new boolean[size];

        backtracking(size, 0);
    }


    private static void backtracking(int size, int depth) {
        if (size == depth) {
            for (int view : result) {
                System.out.print(view + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;
                backtracking(size, depth + 1);
                visited[i] = false;
            }
        }

    }


}
