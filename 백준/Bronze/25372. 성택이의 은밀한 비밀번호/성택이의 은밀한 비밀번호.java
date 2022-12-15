import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int roof = Integer.parseInt(bf.readLine());

        for (int i = 0; i < roof; i++) {
            String input = bf.readLine();
            if (input.length() >= 6 && input.length() <= 9) {
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
    }
}