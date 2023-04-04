import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[] stairs = new int[size + 1];
        int[] result = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }


        result[0] = 0;
        result[1] = stairs[1];
        
        try {
            result[2] = stairs[2] + result[1];
            result[3] = stairs[3] + Math.max(result[0] + stairs[2], result[1]);

            for (int i = 4; i <= size; i++) {
                result[i] = stairs[i] + Math.max(result[i - 3] + stairs[i - 1], result[i - 2]);
            }
        } catch (Exception e) {
        }

        System.out.println(result[size]);
    }
}
