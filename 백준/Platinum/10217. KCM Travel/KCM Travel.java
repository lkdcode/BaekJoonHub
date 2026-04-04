import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int testCaseSize = Integer.parseInt(BR.readLine());

        for (int t = 0; t < testCaseSize; t++) {
            StringTokenizer st = new StringTokenizer(BR.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Node>[] nodeList = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                nodeList[i] = new ArrayList<>();
            }


            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(BR.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                nodeList[u].add(new Node(v, c, d));
            }

            dijkstra(nodeList, n, m);
        }
    }

    private static void dijkstra(List<Node>[] list, int n, int m) {
//        PriorityQueue<Node> pq = new PriorityQueue<>();

        Queue<Node> pq = new LinkedList<>();

        int[][] costList = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(costList[i], Integer.MAX_VALUE);
        }

        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int currentIndex = node.index;
            int currentCost = node.cost;
            int currentTime = node.time;

            if (m < currentCost || costList[currentIndex][currentCost] < currentTime) continue;
            costList[currentIndex][currentCost] = currentTime;

            for (Node nextNode : list[currentIndex]) {
                int nextIndex = nextNode.index;
                int sumNextCost = currentCost + nextNode.cost;
                int sumNextTime = currentTime + nextNode.time;

                if (m < sumNextCost || costList[nextIndex][sumNextCost] <= sumNextTime) continue;

                for (int c = sumNextCost; c <= m; c++) {
                    if (costList[nextIndex][c] > sumNextTime) {
                        costList[nextIndex][c] = sumNextTime;
                    } else {
                        break;
                    }
                }

                pq.add(new Node(nextIndex, sumNextCost, sumNextTime));
            }
        }

        int result = Integer.MAX_VALUE;
        for (int e : costList[n]) {
            result = Math.min(e, result);
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println("Poor KCM");
        } else {
            System.out.println(result);
        }
    }
}

class Node implements Comparable<Node> {
    int index;
    int cost;
    int time;

    public Node(int index, int cost, int time) {
        this.index = index;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}