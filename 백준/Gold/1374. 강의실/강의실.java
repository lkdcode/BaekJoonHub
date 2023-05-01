import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        List<int[]> times = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            times.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        times.sort((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && queue.peek() <= times.get(i)[0]) {
                queue.poll();
            }
            queue.offer(times.get(i)[1]);
            result = Math.max(result, queue.size());
        }

        System.out.println(result);
    }
}