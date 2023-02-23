import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputSize = br.readLine().split(" ");

        int size = Integer.parseInt(inputSize[0]);
        int question = Integer.parseInt(inputSize[1]);

        int[] numbers = new int[size + 1];

        for (int i = 0; i <= size; i++) {
            numbers[i] = i;
        }

        for (int i = 0; i < question; i++) {
            String[] input = br.readLine().split(" ");

            List<Integer> rotateList = new ArrayList<>();

            int startIndex = Integer.parseInt(input[0]);
            int endIndex = Integer.parseInt(input[1]);
            int midIndex = Integer.parseInt(input[2]);

            for (int j = startIndex; j <= endIndex; j++) {
                rotateList.add(numbers[j]);
            }

            Collections.rotate(rotateList, endIndex - midIndex + 1);

            int inputIndex = 0;
            for (int j = startIndex; j <= endIndex; j++) {
                numbers[j] = rotateList.get(inputIndex++);
            }
        }

        for (int view : numbers) {
            if (view != 0) {
                System.out.print(view + " ");
            }
        }

    }
}
