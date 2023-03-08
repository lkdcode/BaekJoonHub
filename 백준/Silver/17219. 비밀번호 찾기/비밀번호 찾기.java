import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputSite = Integer.parseInt(st.nextToken());
        int findPassword = Integer.parseInt(st.nextToken());


        Map<String, String> password = new HashMap<>();

        for (int i = 0; i < inputSite; i++) {
            st = new StringTokenizer(br.readLine());

            password.put(st.nextToken(), st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < findPassword; i++) {
            result.append(password.get(br.readLine()))
                    .append("\n");
        }


        System.out.println(result);
    }
}
