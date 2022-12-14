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

        BigInteger firstNumber = new BigInteger(inputSplit[0]);
        BigInteger secondNumber = new BigInteger(inputSplit[1]);

        System.out.println(firstNumber.add(secondNumber));
    }
}