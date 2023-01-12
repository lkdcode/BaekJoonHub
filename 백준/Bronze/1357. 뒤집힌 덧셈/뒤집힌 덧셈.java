import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputSplit = input.split(" ");
        String reverseFirstNumber = "";
        String reverseSecondNumber = "";

        for (int i = inputSplit[0].length() - 1; i >= 0; i--) {
            reverseFirstNumber += inputSplit[0].charAt(i);
        }

        for (int i = inputSplit[1].length() - 1; i >= 0; i--) {
            reverseSecondNumber += inputSplit[1].charAt(i);
        }

        int firstNumber = Integer.parseInt(reverseFirstNumber);
        int secondNumber = Integer.parseInt(reverseSecondNumber);
        int result = firstNumber + secondNumber;

        String reversResult = String.valueOf(result);
        String answer = "";
        for (int i = reversResult.length() - 1; i >= 0; i--) {
            answer += reversResult.charAt(i);
        }
        int number = Integer.parseInt(answer);
        System.out.println(number);


    }
}
