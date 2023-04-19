import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static StringBuilder RESULT = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        checkNumber(0, 0, size);
        System.out.println(RESULT);
    }


    private static void checkNumber(int row, int column, int size) {
        if (checkResult(row, column, size)) {
            if (map[row][column] == 0) {
                // 0인 경우
                RESULT.append(0);
            } else {
                // 1인 경우
                RESULT.append(1);
            }
            return;
        }
        int newSize = size / 2;
        // ((110(0101))(0010)1(0001))
        RESULT.append("(");
        // 왼쪽 위
        checkNumber(row, column, newSize);
        // 오른쪽 위
        checkNumber(row, column + newSize, newSize);
        // 왼쪽 아래
        checkNumber(row + newSize, column, newSize);
        // 오른쪽 아래
        checkNumber(row + newSize, column + newSize, newSize);
        RESULT.append(")");
    }

    private static boolean checkResult(int row, int column, int size) {
        int target = map[row][column];

        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (target != map[i][j]) return false;
            }
        }

        return true;
    }

}
