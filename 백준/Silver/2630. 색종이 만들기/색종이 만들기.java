import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] confetti;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        confetti = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                confetti[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeResult(0, 0, size);

        System.out.println(white);
        System.out.println(blue);

    }


    private static void makeResult(int row, int column, int size) {
        if (checkColor(row, column, size)) {
            if (confetti[row][column] == 1) {
                blue++;
            } else {
                white++;
            }

        } else {
            int newSize = size / 2;

            makeResult(row, column, newSize);
            makeResult(row + newSize, column, newSize);
            makeResult(row, column + newSize, newSize);
            makeResult(row + newSize, column + newSize, newSize);

        }

    }

    private static boolean checkColor(int row, int column, int size) {
        int color = confetti[row][column];

        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (color != confetti[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }


}
