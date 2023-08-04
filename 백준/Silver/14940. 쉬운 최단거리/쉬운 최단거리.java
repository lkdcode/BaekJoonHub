import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static int[][] map;
    private static int[][] result;
    private static boolean[][] visited;
    private static int startX;
    private static int startY;
    private static int N;
    private static int M;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;

                if (number == 2) {
                    startX = i;
                    startY = j;
                } else if (number == 0) {
                    visited[i][j] = true;
                }
            }

        }

        BFS();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    result[i][j] = -1;
                }
                sb.append(result[i][j])
                        .append(" ");
            }
            sb.append(System.lineSeparator());
        }


        System.out.println(sb);

    }

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + DX[i];
                int newY = y + DY[i];

                if (newX >= 0 && newX < N
                        && newY >= 0 && newY < M
                        && !visited[newX][newY]
                        && map[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    result[newX][newY] = result[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }

            }

        }

    }

}
