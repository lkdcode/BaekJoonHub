import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    public static final int[] DX = {+1, -1, 0, 0};
    public static final int[] DY = {0, 0, +1, -1};

    public static final String EMPTY_SPACE = ".";
    public static final String WALL = "*";
    public static final String DOOR = "#";
    public static final String PRISONER = "$";

    public static List<int[]> START_LIST;

    public static void main(String[] args) throws Exception {
        int count = Integer.parseInt(BR.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(BR.readLine());
            START_LIST = new ArrayList<>();

            int colSize = Integer.parseInt(st.nextToken()) + 2;
            int rowSize = Integer.parseInt(st.nextToken()) + 2;

            String[][] map = new String[colSize][rowSize];

            for (int col = 0; col < colSize; col++) {
                for (int row = 0; row < rowSize; row++) {
                    map[col][row] = EMPTY_SPACE;
                }
            }

            for (int col = 0; col < colSize - 2; col++) {
                String[] input = BR.readLine().split("");

                for (int row = 0; row < rowSize - 2; row++) {
                    String ch = input[row];
                    map[col + 1][row + 1] = ch;

                    if (ch.equals(PRISONER)) {
                        START_LIST.add(new int[]{col + 1, row + 1});
                    }
                }
            }

            long[][] dist1 = dijkstra(map, colSize, rowSize, START_LIST.get(0)[0], START_LIST.get(0)[1]);
            long[][] dist2 = dijkstra(map, colSize, rowSize, START_LIST.get(1)[0], START_LIST.get(1)[1]);
            long[][] dist3 = dijkstra(map, colSize, rowSize);

            long result = Long.MAX_VALUE;

            for (int col = 0; col < colSize; col++) {
                for (int row = 0; row < rowSize; row++) {
                    if (map[col][row].equals(WALL)) continue;

                    if (map[col][row].equals(DOOR)) {
                        result = Math.min(result, (dist1[col][row] + dist2[col][row] + dist3[col][row]) - 2);
                    } else {
                        result = Math.min(result, (dist1[col][row] + dist2[col][row] + dist3[col][row]));
                    }
                }
            }

            System.out.println(result);
        }
    }

    public static long[][] dijkstra(String[][] map, int colSize, int rowSize, int startX, int startY) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        long[][] costList = new long[colSize][rowSize];

        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                costList[i][j] = Long.MAX_VALUE;
            }
        }

        queue.add(new Node(startX, startY, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int currentX = node.x;
            int currentY = node.y;
            long currentCost = node.cost;

            if (costList[currentX][currentY] < currentCost) continue;
            costList[currentX][currentY] = currentCost;

            for (int q = 0; q < 4; q++) {
                int nextX = currentX + DX[q];
                int nextY = currentY + DY[q];

                if (nextX >= 0 && nextX < colSize && nextY >= 0 && nextY < rowSize) {
                    switch (map[nextX][nextY]) {
                        case DOOR -> {
                            if (costList[nextX][nextY] > currentCost + 1) {
                                costList[nextX][nextY] = currentCost + 1;
                                queue.add(new Node(nextX, nextY, currentCost + 1));
                            }
                        }
                        case EMPTY_SPACE, PRISONER -> {
                            if (costList[nextX][nextY] > currentCost) {
                                costList[nextX][nextY] = currentCost;
                                queue.add(new Node(nextX, nextY, currentCost));
                            }
                        }
                    }
                }
            }
        }

        return costList;
    }

    public static long[][] dijkstra(String[][] map, int colSize, int rowSize) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        long[][] costList = new long[colSize][rowSize];

        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                costList[i][j] = Long.MAX_VALUE;
            }
        }

        queue.add(new Node(0, 0, 0L));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int currentX = node.x;
            int currentY = node.y;
            long currentCost = node.cost;

            if (costList[currentX][currentY] < currentCost) continue;
            costList[currentX][currentY] = currentCost;

            for (int q = 0; q < 4; q++) {
                int nextX = currentX + DX[q];
                int nextY = currentY + DY[q];

                if (nextX >= 0 && nextX < colSize && nextY >= 0 && nextY < rowSize) {
                    switch (map[nextX][nextY]) {
                        case DOOR -> {
                            if (costList[nextX][nextY] > currentCost + 1) {
                                costList[nextX][nextY] = currentCost + 1;
                                queue.add(new Node(nextX, nextY, currentCost + 1));
                            }
                        }
                        case EMPTY_SPACE, PRISONER -> {
                            if (costList[nextX][nextY] > currentCost) {
                                costList[nextX][nextY] = currentCost;
                                queue.add(new Node(nextX, nextY, currentCost));
                            }
                        }
                    }
                }
            }
        }

        return costList;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    long cost;

    public Node(int x, int y, long cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return (int) (this.cost - o.cost);
    }
}