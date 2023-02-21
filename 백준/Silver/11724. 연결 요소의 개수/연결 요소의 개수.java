import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] check;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        check = new boolean[node + 1];
        list = new ArrayList[node + 1];

        for (int i = 0; i <= node; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            list[firstNode].add(secondNode);
            list[secondNode].add(firstNode);
        }

        int result = 0;

        for (int i = 1; i <= node; i++) {
            if (!check[i]) {
                result++;
                DFS(i);
            }
        }

        System.out.println(result);
    }

    static void DFS(int index) {
        if (check[index]) {
            return;
        }

        check[index] = true;

        for (int number : list[index]) {
            if (!check[number]) {
                DFS(number);
            }
        }
    }

}
