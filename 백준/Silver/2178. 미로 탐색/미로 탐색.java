import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};
    private static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) { // 상, 하, 좌, 우 탐색
                int x = now[0] + DX[k];
                int y = now[1] + DY[k];

                if (x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안 되고
                    if (A[x][y] != 0 && !visited[x][y]) { // 0이여서 갈 수 없거나 기방문한 곳이면 안 됨
                        // 갈 수 있는 곳이다
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // depth 증가. *핵심
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

    }


}












