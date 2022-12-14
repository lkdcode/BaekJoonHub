import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += Integer.parseInt(bf.readLine());
        }

        System.out.println(result);
    }
}