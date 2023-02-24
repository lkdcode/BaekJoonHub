import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int need = Integer.parseInt(input[1]);

        List<Integer> trees = new ArrayList<>();

        long startIndex = 0;
        long endIndex = 0;

        for (int i = 0; i < size; i++) {
            trees.add(Integer.parseInt(br.readLine()));
            endIndex = Math.max(endIndex, trees.get(i));
        }
        endIndex++;
        while (startIndex < endIndex) {
            long midIndex = (startIndex + endIndex) / 2;
            long sum = 0;

            for (int i = 0; i < trees.size(); i++) {
                sum += trees.get(i) / midIndex;
            }

            if (sum < need) {
                endIndex = midIndex;
            } else {
                startIndex = midIndex + 1;
            }

        }

        System.out.println(startIndex - 1);


    }
}