import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        int mod = 20000303;

        int number = 0;
        for (int i = 0; i < input.length(); i++) {
            number *= 10;
            number += input.charAt(i) - 48;
            number %= mod;
        }

        System.out.println(number);
    }
}