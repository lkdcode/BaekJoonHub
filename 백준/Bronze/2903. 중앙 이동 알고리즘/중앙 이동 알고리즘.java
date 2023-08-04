import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int number = Integer.parseInt(br.readLine());

        int[] result = new int[16];
        int index = 3;

        for (int i = 1; i < result.length; i++) {
            result[i] = index * index;
            index = index + (index - 1);
        }

        System.out.println(result[number]);

    }

}
