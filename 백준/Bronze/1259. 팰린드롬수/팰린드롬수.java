import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = "1";
        while (true) {
            input = bf.readLine();
            if (input.equals("0")) {
                break;
            }
            validate(input);
        }

    }

    private static void validate(String input) {
        String change = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            change += String.valueOf(input.charAt(i));
        }
        if (change.equals(input)) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }
}