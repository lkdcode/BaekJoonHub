import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Stack<Integer> stack = new Stack<>();
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        int target = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            queue.add(number);
        }

        int index = 1;

        while (!queue.isEmpty()) {
            if (queue.peek() == index) {
                queue.poll();
                index++;
            } else if (!stack.isEmpty() && stack.peek() == index) {
                stack.pop();
                index++;
            } else {
                stack.add(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == index) {
                index++;
                stack.pop();
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }

}
