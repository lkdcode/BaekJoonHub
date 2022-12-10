import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// class Main으로 수정
public class Main {
    private static final BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> completion = new ArrayList<>();

        for (int i = 0; i < 28; i++) {
            int number = Integer.parseInt(BF.readLine());
            completion.add(number);
        }

        Collections.sort(completion);

        for (int i = 1; i <= completion.size() + 2; i++) {
            if (!(completion.contains(i))) {
                System.out.println(i);
            }
        }

    }
}