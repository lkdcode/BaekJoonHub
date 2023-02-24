import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] DFSVisited;
    static boolean[] BFSVisited;
    static String DFSResult = "";
    static String BFSResult = "";
    static List<Integer>[] list;


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);

        int startIndex = Integer.parseInt(input[2]);

        DFSVisited = new boolean[node + 1];
        BFSVisited = new boolean[node + 1];
        list = new ArrayList[node + 1];

        for (int i = 0; i <= node; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            int linkIndex = Integer.parseInt(input[1]);

            list[index].add(linkIndex);
            list[linkIndex].add(index);
            Collections.sort(list[index]);
            Collections.sort(list[linkIndex]);
        }


        DFS(startIndex);
        System.out.println(DFSResult);

        BFS(startIndex);
        System.out.println(BFSResult);

    }

    static void DFS(int startIndex) {

        if (DFSVisited[startIndex]) {
            return;
        }

        DFSResult += startIndex + " ";
        DFSVisited[startIndex] = true;

        for (int nextIndex : list[startIndex]) {
            if (!DFSVisited[nextIndex]) {
                DFS(nextIndex);
            }
        }

    }

    static void BFS(int startIndex) {
        BFSVisited[startIndex] = true;
        Queue<Integer> BFSQueue = new LinkedList<>();
        BFSQueue.offer(startIndex);

        while (!BFSQueue.isEmpty()) {
            int newIndex = BFSQueue.poll();
            BFSResult += newIndex + " ";

            for (int secondIndex : list[newIndex]) {
                if(!BFSVisited[secondIndex]){
                    BFSQueue.add(secondIndex);
                    BFSVisited[secondIndex] = true;
                }
            }
        }


    }

}
