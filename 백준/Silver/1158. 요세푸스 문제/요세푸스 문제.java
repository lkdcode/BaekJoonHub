import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= size; i++) {
            queue.offer(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");
        while (!queue.isEmpty()) {

            for (int i = 0; i < target - 1; i++) {
                queue.offer(queue.poll());
            }

            result.append(queue.poll())
                    .append(", ");

        }
        result.delete(result.length() - 2, result.length());
        result.append(">");
        System.out.println(result);

    }
}
