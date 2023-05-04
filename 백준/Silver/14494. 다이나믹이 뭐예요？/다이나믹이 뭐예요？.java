import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[][] DP;
    private static int ROW;
    private static int COLUMN;

    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int DIVISION_NUMBER = 1000000007;

    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void inputSize() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        ROW = Integer.parseInt(st.nextToken());
        COLUMN = Integer.parseInt(st.nextToken());
    }

    private static void solution() throws IOException {
        inputSize();
        makeDP();
        printResult();
    }

    private static void makeDP() {
        DP = new long[ROW + ONE][COLUMN + ONE];

        DP[ZERO][ZERO] = ZERO;

        for (int i = ZERO; i <= ROW; i++) {
            DP[i][ZERO] = ONE;
        }

        for (int i = ZERO; i <= COLUMN; i++) {
            DP[ZERO][i] = ONE;
        }

        for (int i = ONE; i < DP.length; i++) {
            for (int j = ONE; j < DP[i].length; j++) {
                DP[i][j] = (DP[i - ONE][j] + DP[i][j - ONE] + DP[i - ONE][j - ONE]) % DIVISION_NUMBER;
            }
        }
    }

    private static void printResult() {
        System.out.println(DP[ROW - ONE][COLUMN - ONE]);
    }

}
