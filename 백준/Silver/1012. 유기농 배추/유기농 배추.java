import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static int[][] field;
    private static boolean[][] visited;
    private static int row, column;
    private static int result;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            row = Integer.parseInt(st.nextToken());
            column = Integer.parseInt(st.nextToken());

            int cabbage = Integer.parseInt(st.nextToken());

            field = new int[row][column];
            visited = new boolean[row][column];


            for (int j = 0; j < cabbage; j++) {
                st = new StringTokenizer(br.readLine());
                int firstIndex = Integer.parseInt(st.nextToken());
                int secondIndex = Integer.parseInt(st.nextToken());

                field[firstIndex][secondIndex] = 1;
            }

            result = 0;

            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field[i].length; k++) {

                    if (visited[j][k]) {
                        continue;
                    }

                    if (field[j][k] == 1) {
                        findMap(j, k);
                    }

                }
            }

            System.out.println(result);
        }

    }

    private static void findMap(int startIndex, int endIndex) {
        Queue<int[]> queue = new LinkedList<>();
        result++;

        queue.add(new int[]{startIndex, endIndex});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int x = point[0];
            int y = point[1];

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int xIndex = x + DX[k];
                int yIndex = y + DY[k];

                if (xIndex >= 0 && yIndex >= 0 && xIndex < row && yIndex < column) {
                    if (field[xIndex][yIndex] == 1) {
                        queue.add(new int[]{xIndex, yIndex});
                    }
                }
            }

        }
    }
}