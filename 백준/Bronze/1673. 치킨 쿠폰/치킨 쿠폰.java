import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true) {
            String input = br.readLine();

            if (input == null) {
                break;
            }
            String[] inputSplit = input.split(" ");
            int chicken = Integer.parseInt(inputSplit[0]);
            int coupon = Integer.parseInt(inputSplit[1]);
            int order = 0;

            System.out.println(chicken + calculator(chicken, coupon, order));

        }
    }

    private static int calculator(int chicken, int coupon, int order) {

        if (chicken < coupon) {
            return order;
        }
        order += chicken / coupon;
        chicken = (chicken / coupon) + (chicken % coupon);

        return calculator((chicken), (coupon), (order));
    }

}
