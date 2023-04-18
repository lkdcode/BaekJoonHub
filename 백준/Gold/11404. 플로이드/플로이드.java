import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());
        int question = Integer.parseInt(br.readLine());

        int[][] map = new int[size + 1][size + 1];


        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i != j) map[i][j] = INF;
            }
        }

        for (int i = 0; i < question; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstIndex = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[firstIndex][secondIndex] = Math.min(map[firstIndex][secondIndex], cost);
        }

        for (int k = 1; k <= size; k++) {
            for (int startIndex = 1; startIndex <= size; startIndex++) {
                for (int endIndex = 1; endIndex <= size; endIndex++) {
//                    map[startIndex][endIndex] = Math.min(map[startIndex][endIndex], map[startIndex][k] + map[k][endIndex]);
                    if (map[startIndex][endIndex] > map[startIndex][k] + map[k][endIndex]) {
                        map[startIndex][endIndex] = map[startIndex][k] + map[k][endIndex];
                    }
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (map[i][j] == INF) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}
