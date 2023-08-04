import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DX = {1, -1, 0, 0}, DY = {0, 0, 1, -1};
    private static int N, M;
    private static boolean[][] visited;
    private static int[][] map;
    private static int startX;
    private static int startY;
    private static int count;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String o = br.readLine();
            for (int j = 0; j < M; j++) {
                String order = String.valueOf(o.charAt(j));

                if (order.equals("O")) {
                    map[i][j] = 0;
                } else if (order.equals("P")) {
                    map[i][j] = 1;
                } else if (order.equals("X")) {
                    map[i][j] = -1;
                } else {
                    // I
                    startX = i;
                    startY = j;
                    visited[i][j] = true;
                }
            }
        }

        DFS();

        if (count == 0) System.out.println("TT");
        else System.out.println(count);

    }

    private static void DFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + DX[i];
                int newY = y + DY[i];

                if (newX >= 0 && newX < N
                        && newY >= 0 && newY < M
                        && !visited[newX][newY]) {

                    if (map[newX][newY] == 0) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    } else if (map[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        count++;
                    }

                }
            }
        }

    }

}
