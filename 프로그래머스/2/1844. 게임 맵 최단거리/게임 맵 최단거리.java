import java.util.*;

class Solution {
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};
    private static boolean[][] isVisitedByDfs;
    private static boolean[][] isVisitedByBfs;
    private static int maxXSize;
    private static int maxYSize;
    
    public int solution(int[][] maps) {
        int answer = 0;
        maxXSize = maps.length;
        maxYSize = maps[0].length;
        
        isVisitedByBfs = new boolean[maxXSize][maxYSize];
        // isVisitedByDfs = new boolean[maxXSize][maxYSize];
    
        bfs(maps);
        // dfs(maps);
        
        return maps[maxXSize - 1][maxYSize - 1] > 1 ? maps[maxXSize - 1][maxYSize - 1] : -1;
    }
    
    private static void bfs(final int[][] maps) {
        final Queue<int[]> queue = new LinkedList<>();
        final int[] startPosition = {0, 0};
        queue.add(startPosition);

        while (!queue.isEmpty() && maps[maxXSize - 1][maxYSize - 1] <= 1) {
            final int[] position = queue.poll();
            final int xIndex = position[0];
            final int yIndex = position[1];

            isVisitedByBfs[xIndex][yIndex] = true;

            for (int i = 0; i < DX.length; i++) {
                final int newXIndex = DX[i] + xIndex;
                final int newYIndex = DY[i] + yIndex;
                if (newXIndex >= 0 && newXIndex < maxXSize
                        && newYIndex >= 0 && newYIndex < maxYSize
                        && !isVisitedByBfs[newXIndex][newYIndex]
                        && maps[newXIndex][newYIndex] != 0) {
                    maps[newXIndex][newYIndex] = maps[xIndex][yIndex] + 1;
                    queue.add(new int[]{newXIndex, newYIndex});
                    isVisitedByBfs[newXIndex][newYIndex] = true;
                }
            }
        }
    }

    private static void dfs(final int[][] maps) {
        final Stack<int[]> stack = new Stack<>();
        final int[] startPosition = {0, 0};
        stack.add(startPosition);

        while (!stack.isEmpty() && maps[maxXSize - 1][maxYSize - 1] <= 1) {
            final int[] position = stack.pop();
            final int xIndex = position[0];
            final int yIndex = position[1];

            isVisitedByDfs[xIndex][yIndex] = true;

            for (int i = 0; i < DX.length; i++) {
                final int newXIndex = DX[i] + xIndex;
                final int newYIndex = DY[i] + yIndex;
                if (newXIndex >= 0 && newXIndex < maxXSize
                        && newYIndex >= 0 && newYIndex < maxYSize
                        && !isVisitedByDfs[newXIndex][newYIndex]
                        && maps[newXIndex][newYIndex] != 0) {
                    maps[newXIndex][newYIndex] = maps[xIndex][yIndex] + 1;
                    stack.add(new int[]{newXIndex, newYIndex});
                }
            }
        }
    }
}