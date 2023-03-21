import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] DX = {-1, 1};
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int damageSize = Integer.parseInt(st.nextToken());
        int spareSize = Integer.parseInt(st.nextToken());

        int[] players = new int[size + 1];
        visited = new boolean[size + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < damageSize; i++) {
            players[Integer.parseInt(st.nextToken())] -= 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < spareSize; i++) {
            players[Integer.parseInt(st.nextToken())] += 1;
        }

        int result = 0;

        for (int i = 1; i <= size; i++) {
            if (players[i] == -1) {
                for (int j = 0; j < 2; j++) {
                    int index = i + DX[j];
                    if (index >= 1 && index <= size && !visited[index] && players[index] == 1) {
                        visited[index] = true;
                        players[index]--;
                        players[i]++;
                        break;
                    }
                }
            }
        }

        for (int checkNumber : players) {
            if (checkNumber == -1) {
                result++;
            }
        }
        System.out.println(result);

    }

}
