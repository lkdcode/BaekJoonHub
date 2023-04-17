import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int loop = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        check:
        for (int i = 0; i < loop; i++) {
            // input  # start
            String order = br.readLine();
            int size = Integer.parseInt(br.readLine());
            boolean orderNumber = true;
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            Deque<Integer> deque = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }
            // input  # end

            // check null  # start
            for (char c : order.toCharArray()) {
                if (c == 'R') {
                    orderNumber = !orderNumber;
                    continue;
                }

                if (orderNumber) {
                    if (deque.pollFirst() == null) {
                        result.append("error\n");
                        continue check;
                    }

                } else {
                    if (deque.pollLast() == null) {
                        result.append("error\n");
                        continue check;
                    }
                }
            }

            result.append("[");

            while (deque.size() > 0) {
                if (orderNumber) {
                    result.append(deque.pollFirst());

                    while (!deque.isEmpty()) {
                        result.append(",")
                                .append(deque.pollFirst());
                    }

                } else {
                    result.append(deque.pollLast());
                    while (!deque.isEmpty()) {
                        result.append(",")
                                .append(deque.pollLast());
                    }
                }
            }

            result.append("]").append("\n");


        }

        System.out.println(result);
    }
}
