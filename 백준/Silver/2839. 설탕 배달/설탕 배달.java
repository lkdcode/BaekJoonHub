import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int result = 0;

        while (true) {
            if (size % 5 == 0) {
                result += size / 5;
                System.out.println(result);
                break;
            } else {
                size -= 3;
                result++;
            }
            if (size < 0) {
                System.out.println("-1");
                break;
            }
        }
    }
}