import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        int size = Integer.parseInt(br.readLine());


        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int number = 0;
            if (input.length == 2) {
                number = Integer.parseInt(input[1]);
            }
            switch (command) {
                case "push_front":
                    // push_front X: 정수 X를 덱의 앞에 넣는다.
                    deque.addFirst(number);
                    break;
                case "push_back":
                    // push_back X: 정수 X를 덱의 뒤에 넣는다.
                    deque.addLast(number);
                    break;
                case "pop_front":
                    // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pollFirst());
                    }
                    break;
                case "pop_back":
                    // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size":
                    // size: 덱에 들어있는 정수의 개수를 출력한다.
                    System.out.println(deque.size());
                    break;
                case "empty":
                    // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    // front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekFirst());
                    }
                    break;
                case "back":
                    // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;
            }
        }

    }
}