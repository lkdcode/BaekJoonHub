import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int firstSize = Integer.parseInt(input[0]);
        int secondSize = Integer.parseInt(input[1]);

        int[] result = new int[firstSize + secondSize];
        int index = 0;


        input = br.readLine().split(" ");
        for (int i = 0; i < firstSize; i++) {
            result[index++] = (Integer.parseInt(input[i]));
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < secondSize; i++) {
            result[index++] = (Integer.parseInt(input[i]));
        }

        Arrays.sort(result);

        StringBuilder resultPrint = new StringBuilder();

        for (int i : result) {
            resultPrint.append(i + " ");
        }
        System.out.println(resultPrint);
    }
}
