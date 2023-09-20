import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int[] list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        int trimmedAverage = (int) Math.round(size * 0.15);
        int trimmedSize = size - trimmedAverage;

        double result = 0;

        for (int i = trimmedAverage; i < trimmedSize; i++) {
            result += list[i];
        }

        System.out.println(Math.round(result / (trimmedSize - trimmedAverage)));

    }

}
