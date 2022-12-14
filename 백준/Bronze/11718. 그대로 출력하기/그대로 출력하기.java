import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        while (input != null) {
            System.out.println(input);
            input = bf.readLine();
        }
    }
}