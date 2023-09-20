import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        if (size == 0) {
            System.out.println("0");
            return;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int trimmedSize = (int) Math.round(size * 0.15);

        for (int i = 0; i < trimmedSize; i++) {
            priorityQueue.poll();
        }

        int averageSize = size - (trimmedSize * 2);
        double result = 0;

        for (int i = 0; i < averageSize; i++) {
            result += priorityQueue.poll();
        }

        System.out.println(Math.round(result / averageSize));

    }

}
