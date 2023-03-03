import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] DFSVisited;
    private static int[] result;
    private static List<Integer>[] list;

    private static int count = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        int startIndex = Integer.parseInt(st.nextToken());

        DFSVisited = new boolean[node + 1];
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
            Collections.sort(list[i], Collections.reverseOrder());
        }

        DFS(startIndex);


        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static void DFS(int startIndex) {
        if (DFSVisited[startIndex]) {
            return;
        }

        DFSVisited[startIndex] = true;
        result[startIndex] = count++;

        for (int index : list[startIndex]) {
            DFS(index);
        }

    }
}
