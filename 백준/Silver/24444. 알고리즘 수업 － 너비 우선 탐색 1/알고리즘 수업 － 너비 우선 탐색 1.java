import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] BFSVisited;
    private static int[] result;
    private static List<Integer>[] list;
    private static int node, edge;
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        int startIndex = Integer.parseInt(st.nextToken());

        BFSVisited = new boolean[node + 1];
        result = new int[node + 1];

        list = new ArrayList[node + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int firstIndex = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());

            list[firstIndex].add(secondIndex);
            list[secondIndex].add(firstIndex);
        }

        for (int i = 0; i < list.length; i++) {
            Collections.sort(list[i]);
        }

        BFS(startIndex);

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void BFS(int startIndex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startIndex);
        BFSVisited[startIndex] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            result[index] = count++;

            for (int newIndex : list[index]) {
                if (!BFSVisited[newIndex]) {
                    queue.offer(newIndex);
                    BFSVisited[newIndex] = true;
                }
            }
        }
    }
}
