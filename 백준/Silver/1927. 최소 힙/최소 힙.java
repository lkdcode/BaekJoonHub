import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 배열에 자연수 x를 넣는다.
        // 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다

        /**
         * 0 -> 가장 작은 값 출력, 비어있으면 0
         * 12345678
         * 1
         * 2
         * 0 -> 가장 작은 값 출력, 비어있으면 0
         * 0 -> 가장 작은 값 출력, 비어있으면 0
         * 0 -> 가장 작은 값 출력, 비어있으면 0
         * 0 -> 가장 작은 값 출력, 비어있으면 0
         * 32
         */

        int size = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            int order = Integer.parseInt(br.readLine());

            if (order != 0) {
                queue.offer(order);
            } else {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
