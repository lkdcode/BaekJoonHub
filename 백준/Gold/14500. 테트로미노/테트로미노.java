import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int row;
    private static int column;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] DX = {1, -1, 0, 0};
    private static int[] DY = {0, 0, 1, -1};
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        map = new int[row][column];
        visited = new boolean[row][column];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(result);

    }

    private static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xIndex = x + DX[i];
            int yIndex = y + DY[i];

            if (xIndex >= 0 && xIndex < row
                    && yIndex >= 0 && yIndex < column) {

                if (!visited[xIndex][yIndex]) {
                    visited[xIndex][yIndex] = true;
                    dfs(xIndex, yIndex, sum + map[xIndex][yIndex], depth + 1);
                    visited[xIndex][yIndex] = false;
                }

            }
        }

    }

    private static void check(int x, int y) {
        try {
            int total1 = map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1];
            result = Math.max(result, total1);
        } catch (Exception e) {
        }

        try {
            int total2 = map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y + 1];
            result = Math.max(result, total2);
        } catch (Exception e) {
        }

        try {
            int total3 = map[x][y] + map[x][y - 1] + map[x][y + 1] + map[x - 1][y];
            result = Math.max(result, total3);
        } catch (Exception e) {
        }

        try {
            int total4 = map[x][y] + map[x][y - 1] + map[x][y + 1] + map[x + 1][y];
            result = Math.max(result, total4);
        } catch (Exception e) {
        }

    }

}
