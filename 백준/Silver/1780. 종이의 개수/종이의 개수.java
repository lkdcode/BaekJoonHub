import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int MINUS_ONE_RESULT = 0;
    private static int ZERO_RESULT = 0;
    private static int ONE_RESULT = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkColor(0, 0, size);
        System.out.println(MINUS_ONE_RESULT);
        System.out.println(ZERO_RESULT);
        System.out.println(ONE_RESULT);
    }

    private static void checkColor(int row, int column, int size) {
        if (resultCount(row, column, size)) {
            if (map[row][column] == -1) {
                MINUS_ONE_RESULT++;
            } else if (map[row][column] == 0) {
                ZERO_RESULT++;
            } else {
                ONE_RESULT++;
            }

            return;
        }

        int newSize = size / 3;

        // 1 1 3
        checkColor(row, column, newSize);
        // 1 4 3
        checkColor(row, column + newSize, newSize);
        // 1 7 3
        checkColor(row, column + 2 * newSize, newSize);
        // 4 1 3
        checkColor(row + newSize, column, newSize);
        // 4 4 3
        checkColor(row + newSize, column + newSize, newSize);
        // 4 7 3
        checkColor(row + newSize, column + 2 * newSize, newSize);
        // 7 1 3
        checkColor(row + 2 * newSize, column, newSize);
        // 7 4 3
        checkColor(row + 2 * newSize, column + newSize, newSize);
        // 7 4 3
        checkColor(row + 2 * newSize, column + 2 * newSize, newSize);

    }

    private static boolean resultCount(int row, int column, int size) {
        int target = map[row][column];

        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (target != map[i][j]) {
                    return false;
                }

            }
        }

        return true;
    }

}
