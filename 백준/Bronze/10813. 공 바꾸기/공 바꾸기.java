import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int size = Integer.parseInt(input[0]);
        int loop = Integer.parseInt(input[1]);

        int[] basket = new int[size + 1];

        for (int i = 0; i < basket.length; i++) {
            basket[i] = i;
        }


        for (int i = 0; i < loop; i++) {
            input = br.readLine().split(" ");

            int firstBasket = Integer.parseInt(input[0]);
            int secondBasket = Integer.parseInt(input[1]);

            int firstNumber = basket[firstBasket];
            int secondNumber = basket[secondBasket];

            basket[firstBasket] = secondNumber;
            basket[secondBasket] = firstNumber;

        }

        for (int i = 1; i < basket.length; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}
