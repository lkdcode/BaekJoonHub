import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            BigInteger number = new BigInteger(String.valueOf(br.readLine()));
            if (number.isProbablePrime(10)) {
                System.out.println(number);
            } else {
                System.out.println(number.nextProbablePrime());
            }


        }


    }

}
