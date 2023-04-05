import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static char[][] colors;
    private static boolean[][] visited;
    private static int size;

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(br.readLine());
        colors = new char[size][size];
        visited = new boolean[size][size];
        int result = 0;
        int answer = 0;

        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            for (int j = 0; j < size; j++) {
                colors[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    result++;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (colors[i][j] == 'G') {
                    colors[i][j] = 'R';
                }
            }
        }

        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    answer++;
                }
            }
        }

        System.out.print(result + " " + answer);
    }

    private static void DFS(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int xIndex = i + DX[k];
            int yIndex = j + DY[k];
            if (xIndex >= 0 && yIndex >= 0 && xIndex < size && yIndex < size &&
                    colors[i][j] == colors[xIndex][yIndex] && !visited[xIndex][yIndex]) {
                DFS(xIndex, yIndex);
            }
        }
    }

}
