import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[] rootVisited;
    private static int[] root;

    private static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];

        root = new int[size];
        rootVisited = new boolean[size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findRoot(size, 0);

        System.out.println(minCost);
    }


    private static void findRoot(int size, int depth) {
        if (size == depth) {
            int[] newRoot = new int[size + 1];

            for (int i = 0; i < root.length; i++) {
                newRoot[i] = root[i];
            }
            newRoot[root.length] = root[0];

            findCost(newRoot);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!rootVisited[i]) {
                rootVisited[i] = true;
                root[depth] = i + 1;
                findRoot(size, depth + 1);
                rootVisited[i] = false;
            }
        }

    }

    private static void findCost(int[] root) {
        int totalCost = 0;

        for (int i = 0; i < root.length - 1; i++) {
            int x = root[i] - 1;
            int y = root[i + 1] - 1;

            if (map[x][y] == 0) return;

            totalCost += map[x][y];
        }

        minCost = Math.min(minCost, totalCost);
    }


}
