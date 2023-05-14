import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int size;
    private static String[][] map;
    private static final int[] DX = {1, 0};
    private static final int[] DY = {0, 1};
    private static int maxResult = Integer.MIN_VALUE;
    private static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(br.readLine());

        map = new String[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = st.nextToken();
            }
        }

        DFS(map[0][0], 0, 0);
        System.out.println(maxResult + " " + minResult);
    }

    private static void DFS(String calculator, int x, int y) {
        if (x == size - 1 && y == size - 1) {
            calculator(calculator);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int xIndex = x + DX[i];
            int yIndex = y + DY[i];

            if (xIndex >= 0 && xIndex < size
                    && yIndex >= 0 && yIndex < size) {

                String newCalculator = calculator + map[xIndex][yIndex];
                DFS(newCalculator, xIndex, yIndex);
            }

        }

    }

    private static void calculator(String input) {
        int cal = Integer.parseInt(String.valueOf(input.charAt(0)));

        for (int i = 1; i < input.length(); i += 2) {
            int number = Integer.parseInt(String.valueOf(input.charAt(i + 1)));

            switch (input.charAt(i)) {
                case '+':
                    cal += number;
                    break;
                case '-':
                    cal -= number;
                    break;
                case '*':
                    cal *= number;
                    break;
            }
        }

        minResult = Math.min(cal, minResult);
        maxResult = Math.max(cal, maxResult);
    }
}
