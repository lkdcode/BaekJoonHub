import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int number = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i * i <= number; i++) {
            answer++;
        }
        System.out.println(answer);

    }

}
