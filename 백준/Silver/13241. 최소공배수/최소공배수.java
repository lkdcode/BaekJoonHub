import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        long firstNumber = Integer.parseInt(st.nextToken());
        long secondNumber = Integer.parseInt(st.nextToken());

        System.out.println(lcm(firstNumber, secondNumber));
    }

    private static long lcm(long firstNumber, long secondNumber) {

        return (firstNumber * secondNumber) / GCD(firstNumber, secondNumber);
    }


    private static long GCD(long firstNumber, long secondNumber) {

        if (firstNumber % secondNumber == 0) {
            return secondNumber;
        }

        return GCD(secondNumber, firstNumber % secondNumber);
    }


}
