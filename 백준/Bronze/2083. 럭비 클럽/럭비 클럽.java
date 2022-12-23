import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = bf.readLine();
            if (input.equals("# 0 0")) {
                break;
            }
            validate(input);
        }

    }

    private static void validate(String input) {
        String[] inputSplit = input.split(" ");
        if (Integer.parseInt(inputSplit[1]) > 17) {
            System.out.println(inputSplit[0] + " Senior");
            return;
        }
        if (Integer.parseInt(inputSplit[2]) >= 80) {
            System.out.println(inputSplit[0] + " Senior");
            return;
        }

        System.out.println(inputSplit[0] + " Junior");

    }
}