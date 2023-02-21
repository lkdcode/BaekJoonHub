import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int size = Integer.parseInt(input[0]);
        int loop = Integer.parseInt(input[1]);

        int[] basket = new int[size];

        for (int i = 0; i < loop; i++) {
            input = br.readLine().split(" ");
            int startBasket = Integer.parseInt(input[0]) - 1;
            int endBasket = Integer.parseInt(input[1]) - 1;
            int number = Integer.parseInt(input[2]);

            for (int j = startBasket; j <= endBasket; j++) {
                basket[j] = number;
            }

        }
        for (int view : basket) {
            System.out.print(view + " ");
        }

    }
}
