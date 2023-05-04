import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        long[][] map = new long[n + 1][m + 1];


        map[0][0] = 0;

        for (int i = 0; i <= n; i++) {
            map[i][0] = 1;
        }

        for (int i = 0; i <= m; i++) {
            map[0][i] = 1;
        }


        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = (map[i - 1][j] + map[i][j - 1] + map[i - 1][j - 1]) % 1000000007;
            }
        }



        System.out.println(map[n-1][m-1]);


    }

}
