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

        input = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(input[i]);
            list.add(number);
            endIndex = Math.max(endIndex, number);
        }

        while (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            long sum = 0;

            for (int i = 0; i < list.size(); i++) {
                int cut = list.get(i) - midIndex;
                if (cut > 0) {
                    sum += cut;
                }
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
