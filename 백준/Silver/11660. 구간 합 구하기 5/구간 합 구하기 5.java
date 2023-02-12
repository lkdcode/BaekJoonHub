import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int question = Integer.parseInt(stringTokenizer.nextToken());

        int[][] list = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            for (int j = 1; j <= size; j++) {
                list[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }

        }

        int[][] sumList = makeSumList(list, size);
        for (int i = 0; i < question; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int result = sumList[x2][y2] - sumList[x1 - 1][y2] - sumList[x2][y1 - 1] + sumList[x1 - 1][y1 - 1];

            System.out.println(result);

        }
    }

    private static int[][] makeSumList(int[][] list, int size) {
        int[][] sumList = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                sumList[i][j] = sumList[i][j - 1] + sumList[i - 1][j] - sumList[i - 1][j - 1] + list[i][j];
            }
        }

        return sumList;
    }
}

