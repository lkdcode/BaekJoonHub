import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> result = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 절댓값이 o1 가 더 크다면 자리를 바꿔준다.
                if (Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                // 절댓값이 같다면 그대로 음수를 앞으로 보내준다.
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return -1;
                }
            }
        });

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                if (result.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(result.poll());
                }
                continue;
            }
            result.add(number);
        }

    }
}
