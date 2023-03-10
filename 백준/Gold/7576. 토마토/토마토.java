import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] tomatoBox;
    private static int[] DX = {1, 0, -1, 0};
    private static int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        tomatoBox = new int[row][column];

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();


        for (int i = 0; i < row; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());

            for (int j = 0; j < column; j++) {
                int number = Integer.parseInt(input.nextToken());

                if (number == 1) {
                    queue2.offer(i);
                    queue2.offer(j);
                }

                tomatoBox[i][j] = number;
            }
        }

        if (queue2.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int index = 2;

        while (!queue2.isEmpty()) {

            while (!queue2.isEmpty()) {
                queue.offer(queue2.poll());
            }

            while (!queue.isEmpty()) {
                int x = queue.poll();
                int y = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int xIndex = x + DX[i];
                    int yIndex = y + DY[i];

                    if (xIndex >= 0 && yIndex >= 0 && xIndex < row && yIndex < column) {

                        if (tomatoBox[xIndex][yIndex] == 0) {
                            tomatoBox[xIndex][yIndex] = index;
                            queue2.offer(xIndex);
                            queue2.offer(yIndex);
                        }

                    }
                }

            }
            index++;
        }

        int result = -1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tomatoBox[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, tomatoBox[i][j]);

            }
        }

        System.out.println(result - 1);


    }

}