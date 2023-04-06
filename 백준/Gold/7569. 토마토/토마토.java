import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] DC = {1, -1, 0, 0, 0, 0};
    private static int[] DR = {0, 0, 1, -1, 0, 0};
    private static int[] DH = {0, 0, 0, 0, 1, -1};
    private static int[][][] tomatoBox;
    private static int row;
    private static int column;
    private static int height;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        tomatoBox = new int[height][column][row];
        Queue<int[]> check = new LinkedList<>();

        // input
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < column; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < row; k++) {
                    int number = Integer.parseInt(st.nextToken());
                    tomatoBox[i][j][k] = number;
                    if (number == 1) check.offer(new int[]{i, j, k});
                }
            }
        }

        // find
        BFS(check);

        int result = -9999;

        // 0 있으면 -1 리턴
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < row; k++) {
                    result = Math.max(result, tomatoBox[i][j][k]);
                    if (tomatoBox[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result - 1);

    }

    private static void BFS(Queue<int[]> check) {
        while (!check.isEmpty()) {
            int[] index = check.poll();

            int h = index[0];
            int c = index[1];
            int r = index[2];

            for (int i = 0; i < 6; i++) {
                int hIndex = h + DH[i];
                int cIndex = c + DC[i];
                int rIndex = r + DR[i];

                if (hIndex >= 0 && hIndex < height
                        && cIndex >= 0 && cIndex < column
                        && rIndex >= 0 && rIndex < row
                        && tomatoBox[hIndex][cIndex][rIndex] == 0) {
                    tomatoBox[hIndex][cIndex][rIndex] = tomatoBox[h][c][r] + 1;
                    check.offer(new int[]{hIndex, cIndex, rIndex});
                }
            }

        }
    }

}
