import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static PriorityQueue<Integer>[] nodeList;
    private static int[] resultArr;
    private static StringBuilder result;
    private static int resultIndex = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(st.nextToken());

        nodeList = new PriorityQueue[nodeSize + 1];
        visited = new boolean[nodeSize + 1];
        resultArr = new int[nodeSize + 1];


        // O(nodeSize)
        for (int i = 0; i <= nodeSize; i++) {
            nodeList[i] = new PriorityQueue<>();
        }

        // O(edgeSize)
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int firstIndex = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());

            nodeList[firstIndex].add(secondIndex);
            nodeList[secondIndex].add(firstIndex);
        }

        BFS(startIndex);

        // O(nodeSize)
        result = new StringBuilder();
        for (int i = 1; i <= nodeSize; i++) {
            result.append(resultArr[i])
                    .append(System.lineSeparator());
        }
        System.out.println(result.toString());
    }

    private static void BFS(int startIndex) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);

        // O(edgeSize)
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (visited[index]) continue;

            visited[index] = true;
            resultArr[index] = resultIndex++;

            while (!nodeList[index].isEmpty()) {
                queue.offer(nodeList[index].poll());
            }

        }
    }
}
