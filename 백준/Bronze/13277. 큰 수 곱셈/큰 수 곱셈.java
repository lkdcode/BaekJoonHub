import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");
        BigInteger num1 = new BigInteger(inputSplit[0]);
        BigInteger num2 = new BigInteger(inputSplit[1]);
        System.out.println(num1.multiply(num2));
    }
}