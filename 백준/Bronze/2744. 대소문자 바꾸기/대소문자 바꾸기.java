import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char add = input.charAt(i);
            if (add >= 65 && add <= 90) {
                add += 32;
                result+=String.valueOf(add);
                continue;
            }
            if (add >= 97 && add <= 122) {
                add -= 32;
                result += String.valueOf(add);
            }
        }
        System.out.println(result);
    }
}