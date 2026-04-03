import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(BR.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(BR.readLine());

        int[] gasList = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            gasList[i] = Integer.parseInt(st.nextToken());
        }

        List<Node>[] list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(BR.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            list[startIndex].add(new Node(endIndex, cost));
            list[endIndex].add(new Node(startIndex, cost));
        }

        long[][] costList = dijkstra(list, gasList);

        long result = Long.MAX_VALUE;

        for (long l : costList[n]) {
            result = Math.min(result, l);
        }

        System.out.println(result);
    }

    public static long[][] dijkstra(List<Node>[] nodeList, int[] gasList) {
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();

        long[][] costList = new long[2501][2501];
        int[] minGasHistory = new int[2501];
        Arrays.fill(minGasHistory, Integer.MAX_VALUE);

        for (int i = 0; i < 2501; i++) {
            for (int j = 0; j < 2501; j++) {
                costList[i][j] = Long.MAX_VALUE;
            }
        }

        pq.add(new QueueNode(1, 0L, gasList[1]));

        while (!pq.isEmpty()) {
            QueueNode qn = pq.poll();

            int currentIndex = qn.index;
            long currentTotalCost = qn.totalCost;
            int currentMinGas = qn.minGas;

            if (minGasHistory[currentIndex] < currentMinGas) continue;
            minGasHistory[currentIndex] = currentMinGas;

            if (costList[currentIndex][currentMinGas] < currentTotalCost) continue;
            costList[currentIndex][currentMinGas] = currentTotalCost;

            for (Node node : nodeList[currentIndex]) {
                int nextIndex = node.index;
                long nextTotalCost = (node.cost * currentMinGas) + currentTotalCost;
                int nextMinGas = gasList[nextIndex];

                if (costList[nextIndex][nextMinGas] > nextTotalCost) {
                    costList[nextIndex][nextMinGas] = nextTotalCost;

                    pq.add(new QueueNode(nextIndex, nextTotalCost, nextMinGas));
                }

                if (costList[nextIndex][currentMinGas] > nextTotalCost) {
                    costList[nextIndex][currentMinGas] = nextTotalCost;

                    pq.add(new QueueNode(nextIndex, nextTotalCost, currentMinGas));
                }
            }
        }

        return costList;
    }
}

class QueueNode implements Comparable<QueueNode> {
    int index;
    long totalCost;
    int minGas;

    public QueueNode(int index, long totalCost, int minGas) {
        this.index = index;
        this.totalCost = totalCost;
        this.minGas = minGas;
    }

    @Override
    public int compareTo(QueueNode o) {
        return (int) (totalCost - o.totalCost);
    }
}

class Node implements Comparable<Node> {
    int index;
    long cost;

    public Node(int index, long cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return (int) (this.cost - other.cost);
    }
}