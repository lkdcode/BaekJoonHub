import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int[] result = new int[9];
        String[] player = new String[9];
        visited = new boolean[9];

        String skip = "";
        for (int i = 0; i < column - 2; i++) {
            skip += ".";
        }

        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            if (input.contains(skip)) {
                i--;
                continue;
            }
            player[i] = input;
        }

        String[] playerSort = new String[9];

        int inputCount = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j <= 9; j++) {
                String find = String.valueOf(j);
                if (player[i].contains(find)) {
                    playerSort[j - 1] = player[i];
                }
            }
        }


        int resultCount = column - 2;
        int rank = 1;

        for (int i = resultCount; i >= 0; i--) {
            int checkCount = 0;
            for (int j = 0; j < playerSort.length; j++) {
                if (playerSort[j].charAt(i) != '.' && !visited[j]) {
                    result[j] = rank;
                    visited[j] = true;
                    checkCount++;
                }
            }
            if (checkCount != 0) {
                rank++;
            }

        }


        for (int view : result) {
            System.out.println(view);
        }

    }
}
