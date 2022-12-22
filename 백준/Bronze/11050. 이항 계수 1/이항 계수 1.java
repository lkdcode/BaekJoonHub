import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class

Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // n    이항 계수 공식
        // k    n! / k!(n-k)!
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");
        int numberN = Integer.parseInt(inputSplit[0]);
        int numberK = Integer.parseInt(inputSplit[1]);

        int result = factorial(numberN) / (factorial((numberN - numberK)) * factorial(numberK));

        System.out.println(result);

    }

    private static int factorial(int number) {
        int fac = 1;
        for (int i = 1; i <= number; i++) {
            fac *= i;
        }
        return fac;
    }
}