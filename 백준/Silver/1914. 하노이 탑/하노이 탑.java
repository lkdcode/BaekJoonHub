import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder RESULT = new StringBuilder();
    private static BigInteger COUNT = new BigInteger("2");

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        if (size <= 20) {
            hanoi(size, 1, 3, 2);
            System.out.println(COUNT.pow(size).subtract(new BigInteger("1")));
            System.out.println(RESULT);
        } else {
            System.out.println(COUNT.pow(size).subtract(new BigInteger("1")));
        }
    }

    private static void hanoi(int size, int from, int to, int other) {
        if (size == 0) return;

        hanoi(size - 1, from, other, to);
        RESULT.append(from)
                .append(" ")
                .append(to)
                .append(System.lineSeparator());
        hanoi(size - 1, other, to, from);
    }


}