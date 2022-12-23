import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());
        int[][] spec = new int[size][2];

        for (int i = 0; i < size; i++) {
            String input = bf.readLine();
            String[] inputSplit = input.split(" ");
            spec[i][0] = Integer.parseInt(inputSplit[0]);
            spec[i][1] = Integer.parseInt(inputSplit[1]);
        }

        String result = new String();

        for (int i = 0; i < size; i++) {
            int rank = 1;
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                if (spec[i][0] < spec[j][0] && spec[i][1] < spec[j][1]) {
                    rank++;
                }
            }
            result += rank + " ";
        }

        result = result.trim();
        System.out.println(result);

    }
}