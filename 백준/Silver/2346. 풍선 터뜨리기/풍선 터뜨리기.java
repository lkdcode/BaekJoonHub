import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> check = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            deque.offer(input);
            check.offer(index++);
        }

        String answer = "";
        String result = "";

        while (true) {
//            System.out.println("deque = " + deque);
            int number = deque.poll();
            int input = check.poll();
            answer += number + " ";
            result += input + " ";

            if (deque.isEmpty()) break;

            if (number > 0) {
                for (int i = 0; i < number-1; i++) {
                    deque.addLast(deque.poll());
                    check.addLast(check.poll());
                }
            } else {
                for (int i = number; i < 0; i++) {
                    deque.addFirst(deque.pollLast());
                    check.addFirst(check.pollLast());
                }
            }


        }

//        System.out.println(answer);
        System.out.println(result);


    }
}
