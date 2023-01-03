
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] inputSplit = input.split(" ");

        int maxNumber = Integer.parseInt(inputSplit[0]);
        int minNumber = Integer.parseInt(inputSplit[0]);
        for (String add : inputSplit) {
            maxNumber = Math.max(maxNumber, Integer.parseInt(add));
            minNumber = Math.min(minNumber, Integer.parseInt(add));
        }
        int result = maxNumber * minNumber;
        System.out.println(result);
    }
}
