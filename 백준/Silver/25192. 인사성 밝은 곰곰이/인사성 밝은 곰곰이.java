import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Set<String> ID_LIST = new HashSet<>();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                count += ID_LIST.size();
                ID_LIST = new HashSet<>();
                continue;
            }

            ID_LIST.add(input);
        }
        count += ID_LIST.size();
        System.out.println(count);

    }

}
