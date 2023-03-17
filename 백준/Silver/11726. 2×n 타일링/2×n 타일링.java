import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] tiles;

    public static void main(String[] args) throws IOException {
        // TODO : 점화식 구해서 풀기
        int size = Integer.parseInt(br.readLine());
        tiles = new int[size + 1];
        tiles[0] = 0;
        tiles[1] = 1;


        if (size >= 2) {
            tiles[2] = 2;
            for (int i = 3; i <= size; i++) {
                tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10007;
            }
        }

        System.out.println(tiles[size]);

    }
}
