import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(br.readLine());
        // 1 <= number <= 100,000

        int[] list = new int[(int) Math.max(11, (number + 1))];
        list[0] = -1;
        list[1] = -1;
        list[2] = 1;
        list[3] = -1;
        list[4] = 2;
        list[5] = 1;
        list[6] = 3;
        list[7] = 2;
        list[8] = 4;
        list[9] = 3;
        list[10] = 2;

        for (int i = 11; i <= number; i++) {
            list[i] = list[i - 5] + 1;
        }

        System.out.println(list[number]);


    }

}
