import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BigInteger num1 = new BigInteger(bf.readLine());
        BigInteger num2 = new BigInteger(bf.readLine());


        num2 = num1.add(num2);
        BigInteger num = new BigInteger("2");

        System.out.println(num2.divide(num));
        System.out.println(num1.subtract(num2.divide(num)));

    }
}