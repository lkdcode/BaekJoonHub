import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int[] count;

    private static int DFSIndex = 0;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);

        list = new ArrayList[node + 1];


        count = new int[node + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstIndex = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());

            list[secondIndex].add(firstIndex);
        }

        for (int i = 1; i < list.length; i++) {
            visited = new boolean[node + 1];
            DFSIndex = i;
            DFS(i);
        }

        int max = Integer.MIN_VALUE;

        for (int number : count) {
            max = Math.max(max, number);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < count.length; i++) {
            if (count[i] == max) {
                result.append(i).append(" ");
            }
        }

        System.out.println(result);
    }

    private static void DFS(int startIndex) {
        count[DFSIndex]++;

        if (visited[startIndex]) {
            return;
        }

        visited[startIndex] = true;

//        try {
            for (int index : list[startIndex]) {
                if (!visited[index]) {
                    DFS(index);
                }
            }
//        } catch (NullPointerException e) {
//        }

    }

}
