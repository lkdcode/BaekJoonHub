import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] DX = {1, -1, 0, 0};
    private static int[] DY = {0, 0, 1, -1};
    private static String[][] sheep;
    private static boolean[][] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            sheep = new String[row][column];
            visited = new boolean[row][column];
            result = 0;

            for (int j = 0; j < sheep.length; j++) {
                String input = br.readLine();
                for (int k = 0; k < input.length(); k++) {
                    sheep[j][k] = String.valueOf(input.charAt(k));
                }
            }

            for (int j = 0; j < sheep.length; j++) {
                for (int k = 0; k < sheep[j].length; k++) {
                    if (!visited[j][k] && sheep[j][k].equals("#")) {
                        DFS(j, k);
                        result++;
                    }
                }
            }

            System.out.println(result);

        }

    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        if (sheep[x][y].equals(".")) return;

        for (int i = 0; i < 4; i++) {
            int xIndex = x + DX[i];
            int yIndex = y + DY[i];

            if (xIndex >= 0 && xIndex < sheep.length
                    && yIndex >= 0 && yIndex < sheep[0].length
                    && sheep[xIndex][yIndex].equals("#")
                    && !visited[xIndex][yIndex]) {
                DFS(xIndex, yIndex);
            }
        }


    }

}
