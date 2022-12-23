import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");
        int[] numbers = new int[inputSplit.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputSplit[i]);
        }
        
        Arrays.sort(numbers);
        String result = new String();

        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i] + " ";
        }
        
        result = result.trim();
        
        System.out.println(result);

    }
}