import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int timeResult = Integer.MAX_VALUE;
    private static int blockResult = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int inventory = Integer.parseInt(st.nextToken());

        int[][] plate = new int[row][column];

        int maxBlock = Integer.MIN_VALUE;
        int minBlock = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                int number = Integer.parseInt(st.nextToken());
                plate[i][j] = number;
                maxBlock = Math.max(maxBlock, number);
                minBlock = Math.min(minBlock, number);
            }
        }

        for (int i = minBlock; i <= maxBlock; i++) {
            findResult(i, plate, inventory);
        }

        System.out.println(timeResult + " " + blockResult);
    }

    static void findResult(int blockIndex, int[][] plate, int inventory) {
        int time = 0;
        int block = 0;

        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                block = plate[i][j];
                if (block == blockIndex) {
                    continue;
                } else if (block > blockIndex) {
                    // 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
                    // 2초

                    inventory += block - blockIndex;
                    time += (block - blockIndex) * 2;

                } else {
                    // 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.
                    // 1초
                    inventory -= blockIndex - block;



                    time += blockIndex - block;
                }

            }
        }
        
        if (inventory < 0) {
            return;
        }

        if (timeResult >= time && blockResult < blockIndex) {
            timeResult = time;
            blockResult = blockIndex;
        }

    }
}
