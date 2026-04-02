import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<String> mList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            String sb = startIndex + " " + endIndex + " " + cost;

            mList.add(sb);
        }

        List<Long> taxList = new ArrayList<>();
        long appendTax = 0;
        taxList.add(appendTax);
        for (int i = 0; i < k; i++) {
            long tax = Integer.parseInt(br.readLine());
            taxList.add(tax + appendTax);
            appendTax += tax;
        }

        List<Node>[] list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (String input : mList) {
            String[] split = input.split(" ");
            int startIndex = Integer.parseInt(split[0]);
            int endIndex = Integer.parseInt(split[1]);
            long cost = Long.parseLong(split[2]);

            list[startIndex].add(new Node(endIndex, cost));
            list[endIndex].add(new Node(startIndex, cost));
        }

        long[][] costWithEdgeList = dijkstra2(list, n, m, s, d);

        for (long tax : taxList) {
            long result = Long.MAX_VALUE;

            for (int i = 1; i <= m; i++) {
                if (costWithEdgeList[d][i] == Long.MAX_VALUE) continue;

                long cost = costWithEdgeList[d][i] + (i * tax);
                result = Math.min(result, cost);
            }

            System.out.println(result);
        }
    }

    private static long[][] dijkstra2(List<Node>[] list, int n, int m, int s, int d) {
        PriorityQueue<Node2> pq = new PriorityQueue<>();

        long[][] costWithEdgeList = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                costWithEdgeList[i][j] = Long.MAX_VALUE;
            }
        }

        pq.add(new Node2(s, 0, 0));

        while (!pq.isEmpty()) {
            Node2 currentNode = pq.poll();
            int currentIndex = currentNode.index;
            int currentEdgeCount = currentNode.edgeCount;
            long currentCost = currentNode.cost;

            for (Node node : list[currentIndex]) {
                int nextEdgeCount = currentEdgeCount + 1;

                if (nextEdgeCount > m) continue;

                long nextCost = currentCost + node.cost;
                int nextIndex = node.index;

                boolean isPromising = true;

                for (int i = 1; i <= nextEdgeCount; i++) {
                    if (costWithEdgeList[nextIndex][i] < nextCost) {
                        isPromising = false;
                        break;
                    }
                }

                if (isPromising) {
                    costWithEdgeList[nextIndex][nextEdgeCount] = nextCost;

                    pq.add(new Node2(nextIndex, nextEdgeCount, nextCost));
                }
            }
        }

        return costWithEdgeList;
    }
}

class Node2 implements Comparable<Node2> {
    int index;
    int edgeCount;
    long cost;

    public Node2(int index, int edgeCount, long cost) {
        this.index = index;
        this.edgeCount = edgeCount;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node2 o) {
        return (int) (this.cost - o.cost);
    }
}

class Node implements Comparable<Node> {
    int index;
    long cost;

    public Node(int s, long cost) {
        this.index = s;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return (int) (this.cost - o.cost);
    }
}