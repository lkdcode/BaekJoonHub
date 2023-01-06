import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputSplit = input.split(" ");

        int startNumber = Integer.parseInt(inputSplit[0]);
        int endNumber = Integer.parseInt(inputSplit[1]);

        int result = 0;
        int index = 0;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= i; j++) {
                index++;
                if (index >= startNumber && index <= endNumber) {
                    result += i;
                }
            }
        }

        System.out.println(result);

    }
}
