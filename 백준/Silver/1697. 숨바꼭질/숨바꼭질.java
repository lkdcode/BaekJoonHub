import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static Queue<Integer> visited = new LinkedList<>();


    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        int second = 0;

        queue.offer(start);

        while (!visited[end]) {
            second++;
            Queue<Integer> calculator = new LinkedList<>();

            while (!queue.isEmpty()) {
                int number = queue.poll();

                int plus = number + 1;
                int minus = number - 1;
                int multiple = number * 2;

                if (plus <= 100000 && !visited[plus]) {
                    calculator.offer(plus);
                }

                if (minus >= 0 && minus <= 100000 && !visited[minus]) {
                    calculator.offer(minus);
                }

                if (multiple <= 100000 && !visited[multiple]) {
                    calculator.offer(multiple);
                }

                visited[number] = true;

            }

            while (!calculator.isEmpty()) {
                queue.offer(calculator.poll());
            }

        }

        System.out.println(second - 1);

    }

}
