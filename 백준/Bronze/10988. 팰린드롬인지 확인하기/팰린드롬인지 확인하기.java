import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        String change = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            change += String.valueOf(input.charAt(i));
        }

        if (input.equals(change)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
