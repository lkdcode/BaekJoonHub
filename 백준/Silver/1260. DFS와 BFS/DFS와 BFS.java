
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder result = new StringBuilder();
    private static List<Integer>[] list;
    private static boolean[] DFSVisited;
    private static boolean[] BFSVisited;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(BR.readLine());

        int N = Integer.parseInt(st.nextToken()) + 1;
        int M = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        DFSVisited = new boolean[N];
        BFSVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(BR.readLine());
            int firstIndex = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());

            list[firstIndex].add(secondIndex);
            list[secondIndex].add(firstIndex);

            Collections.sort(list[firstIndex]);
            Collections.sort(list[secondIndex]);
        }

        DFS(startIndex);
        result.append(System.lineSeparator());
        BFS(startIndex);

        System.out.println(result);
    }

    private static void DFS(int startIndex) {
        if (DFSVisited[startIndex]) {
            return;
        }

        DFSVisited[startIndex] = true;
        result.append(startIndex)
                .append(" ");

        for (int newIndex : list[startIndex]) {
            if (!DFSVisited[newIndex]) {
                DFS(newIndex);
            }
        }

    }

    private static void BFS(int startIndex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int index = queue.poll();

            if (!BFSVisited[index]) {
                result.append(index)
                        .append(" ");
                BFSVisited[index] = true;
            }


            for (int newIndex : list[index]) {
                if (!BFSVisited[newIndex]) {
                    queue.add(newIndex);
                }
            }

        }

    }

}
