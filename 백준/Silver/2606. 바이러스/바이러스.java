import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int result = 0;

    private static Set<Integer> setResult = new HashSet<>();

    private static List<Integer>[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int computerSize = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        list = new ArrayList[computerSize + 1];
        visited = new boolean[computerSize + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstIndex = Integer.parseInt(st.nextToken());
            int secondIndex = Integer.parseInt(st.nextToken());

            list[firstIndex].add(secondIndex);
            list[secondIndex].add(firstIndex);
        }

        BFS(1);

        System.out.println(setResult.size() - 1);
    }

    private static void BFS(int startIndex) {
        if (visited[startIndex]) {
            return;
        }

        visited[startIndex] = true;
//        result++;
        setResult.add(startIndex);

        for (int index : list[startIndex]) {
            if (!visited[index]) {
                BFS(index);
            }
        }

    }

}
