import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int won = Integer.parseInt(st.nextToken());

        int[] coin = new int[size];

        for (int i = 0; i < size; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        for (int i = size - 1; i >= 0; i--) {
            if (coin[i] <= won) {
                result += won / coin[i];
                
                won %= coin[i];

                if (won == 0) {
                    break;
                }

            }

        }

        System.out.println(result);


    }
}
