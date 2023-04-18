import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int hint = Integer.parseInt(st.nextToken());

        int[][] list = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i != j) list[i][j] = 1000000;

            }
        }

        for (int i = 0; i < hint; i++) {
            st = new StringTokenizer(br.readLine());
            int firstIndex = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());
            list[firstIndex][secondIndex] = list[secondIndex][firstIndex] = 1;
        }

        for (int k = 1; k <= size; k++) {
            for (int startIndex = 1; startIndex <= size; startIndex++) {
                for (int endIndex = 1; endIndex <= size; endIndex++) {
                    list[startIndex][endIndex] = Math.min(list[startIndex][endIndex], list[startIndex][k] + list[k][endIndex]);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= size; i++) {
            int sum = 0;
            for (int j = 1; j <= size; j++) {
                sum += list[i][j];
            }
            min = Math.min(sum, min);
            result.add(sum);
        }

        for (int i = 0; i < result.size(); i++) {
            if (min == result.get(i)) {
                System.out.println(i + 1);
                return;
            }
        }


    }
}