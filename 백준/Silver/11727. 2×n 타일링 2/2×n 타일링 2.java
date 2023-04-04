import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        int size = Integer.parseInt(br.readLine());

        if (size == 1) {
            System.out.println(1);
            return;
        }

        if (size == 2) {
            System.out.println(3);
            return;
        }

        if (size == 3) {
            System.out.println(5);
            return;
        }

        if (size == 4) {
            System.out.println(11);
            return;
        }

        int[] result = new int[size + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 3;
        result[3] = 5;

        for (int i = 4; i <= size; i++) {
            result[i] = (result[i - 1] + (result[i - 2] * 2)) % 10007;
        }
        System.out.println(result[size]);
    }

}
