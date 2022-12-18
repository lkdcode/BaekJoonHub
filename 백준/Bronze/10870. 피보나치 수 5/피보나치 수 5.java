import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(bf.readLine());

        System.out.println(calculator(size));

    }

    private static int calculator(int size) {
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return 1;
        }
        return (calculator(size - 1)) + (calculator(size - 2));
    }
}