import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final List<List<Node>> GRAPH = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < nodeSize + 1; i++) {
            GRAPH.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeSize; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(input.nextToken());
            int edge = Integer.parseInt(input.nextToken());
            int cost = Integer.parseInt(input.nextToken());

            GRAPH.get(nodeNumber).add(new Node(edge, cost));
        }

        int[] costList = dijkstra(nodeSize, startNode, GRAPH);

        for (int i = 1; i <= nodeSize; i++) {
            int cost = costList[i];

            if (cost == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(cost);
            }
        }
    }

    private static int[] dijkstra(int nodeSize, int startNode, List<List<Node>> graph) {
        int[] costList = new int[nodeSize + 1];
        Arrays.fill(costList, Integer.MAX_VALUE);

        costList[startNode] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(new Node(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();

            if (currentNode.cost > costList[currentNode.index]) continue;

            for (Node nextNode : graph.get(currentNode.index)) {
                int sumCost = currentNode.cost + nextNode.cost;

                if (costList[nextNode.index] > sumCost) {
                    costList[nextNode.index] = sumCost;
                    priorityQueue.offer(new Node(nextNode.index, sumCost));
                }
            }
        }

        return costList;
    }
}


class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int nextIndex, int cost) {
        this.index = nextIndex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}