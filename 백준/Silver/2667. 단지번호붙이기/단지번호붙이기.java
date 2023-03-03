import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] DX = {1, 0, -1, 0};
    private static int[] DY = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int[][] map;
    private static int size;

    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        // 입력 완료

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                BFS(i, j);
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        result.forEach(System.out::println);

    }


    private static void BFS(int queueX, int queueY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{queueX, queueY});

        int count = 0;

        int[] check = queue.peek();
        if(!visited[check[0]][check[1]] && map[check[0]][check[1]] == 1){
            count++;
        }

        while (!queue.isEmpty()) {
            int[] index = queue.poll();

            int x = index[0];
            int y = index[1];

            if (map[x][y] == 1) {

                visited[x][y] = true;

                for (int i = 0; i < 4; i++) {

                    int xIndex = x + DX[i];
                    int yIndex = y + DY[i];

                    if (xIndex >= 0 && yIndex >= 0 && xIndex < size && yIndex < size) {
                        if (!visited[xIndex][yIndex]) {
                            if (map[xIndex][yIndex] == 1) {
                                ++count;
                                queue.offer(new int[]{xIndex, yIndex});
                                visited[xIndex][yIndex] = true;
                            }

                        }

                    }

                }

            }
        }
        if (count != 0) {
            result.add(count);
        }
    }


}
