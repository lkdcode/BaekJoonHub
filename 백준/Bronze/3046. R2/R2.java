import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");

        int firstNumber = Integer.parseInt(inputSplit[0]);
        int secondNumber = Integer.parseInt(inputSplit[1]);

        int result = 2 * secondNumber - firstNumber;

        System.out.println(result);

    }
}