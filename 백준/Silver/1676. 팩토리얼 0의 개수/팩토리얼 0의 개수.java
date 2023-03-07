import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(br.readLine());

        int five = 0;
        int two = 0;
        for (int i = 1; i <= number; i++) {
            int index = i;

            while (index % 2 == 0) {
                index /= 2;
                two++;
            }

            while (index % 5 == 0) {
                index /= 5;
                five++;
            }

        }

        System.out.println(Math.min(five, two));
    }

}
