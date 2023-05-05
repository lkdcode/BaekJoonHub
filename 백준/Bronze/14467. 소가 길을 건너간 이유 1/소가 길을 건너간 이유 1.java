
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        String[] moves = new String[11];
        Arrays.fill(moves, "");

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());

            moves[cow] += move;
        }

        int result = 0;
        for (String move : moves) {
            for (int i = 0; i < move.length() - 1; i++) {
                if (move.charAt(i) != move.charAt(i + 1)) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }

}
