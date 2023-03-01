import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        int size = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    // push X: 정수 X를 큐에 넣는 연산이다.
                    int number = Integer.parseInt(st.nextToken());
                    queue.offer(number);
                    break;
                case "front":
                    // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (queue.isEmpty()) {
                        result.append(-1).append("\n");
                    } else {
                        result.append(queue.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (queue.isEmpty()) {
                        result.append(-1).append("\n");
                    } else {
                        result.append(queue.peekLast()).append("\n");
                    }
                    break;
                case "size":
                    // size: 큐에 들어있는 정수의 개수를 출력한다.
                    result.append(queue.size()).append("\n");
                    break;
                case "empty":
                    // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
                    if (queue.isEmpty()) {
                        result.append(1).append("\n");
                    } else {
                        result.append(0).append("\n");
                    }
                    break;
                case "pop":
                    // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (queue.isEmpty()) {
                        result.append(-1).append("\n");
                    } else {
                        result.append(queue.pollFirst()).append("\n");
                    }
                    break;
            }


        }

        System.out.println(result);
    }
}
