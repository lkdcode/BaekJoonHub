import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] map = new int[101];
        boolean[] visited = new boolean[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladders = Integer.parseInt(st.nextToken());
        int snakes = Integer.parseInt(st.nextToken());

        for (int i = 0; i < ladders + snakes; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            map[startIndex] = endIndex;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int count = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int number = queue.poll();

                map[number] = count;

                if (number == 100) {
                    System.out.println(count);
                    return;
                }

                for (int j = 1; j <= 6; j++) {
                    int newNumber = number + j;

                    if (newNumber <= 100 && !visited[newNumber]) {
                        visited[newNumber] = true;

                        if (map[newNumber] != 0) {
                            visited[map[newNumber]] = true;
                            queue.add(map[newNumber]);
                        } else {
                            queue.add(newNumber);
                        }

                    }
                }
            }

            count++;
        }

        System.out.println(0);
    }

}
