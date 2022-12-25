import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());

        for (int i = 0; i < size; i++) {
            String input = bf.readLine();
            String[] inputSplit = input.split(" ");

            int firstNumber = Integer.parseInt(inputSplit[0]);
            int secondNumber = Integer.parseInt(inputSplit[1]);

            result(firstNumber, secondNumber);
        }


    }

    private static void result(int firstNumber, int secondNumber) {
        int resultNumber = 1;

        for (int i = 0; i < secondNumber; i++) {
            resultNumber *= firstNumber;
            resultNumber %= 10;
        }
        if (resultNumber == 0) {
            System.out.println("10");
            return;
        }
        System.out.println(resultNumber);

    }
}