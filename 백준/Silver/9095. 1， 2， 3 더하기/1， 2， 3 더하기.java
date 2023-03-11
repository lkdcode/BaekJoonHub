import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] result = new int[12];

    public static void main(String[] args) throws IOException {
        makeResult();
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(result[number]);

        }


    }

    private static void makeResult() {
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;
        result[4] = 7;

        for (int i = 5; i <= 11; i++) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
        }


    }


}
