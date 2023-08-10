import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final Set<String> SET = new HashSet<>();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstName = st.nextToken();
            String secondName = st.nextToken();

            if (firstName.equals("ChongChong") || secondName.equals("ChongChong")) {
                SET.add(firstName);
                SET.add(secondName);
                for (int j = i + 1; j < T; j++) {
                    i++;
                    st = new StringTokenizer(br.readLine());
                    firstName = st.nextToken();
                    secondName = st.nextToken();
                    if (SET.contains(firstName) || SET.contains(secondName)) {
                        SET.add(firstName);
                        SET.add(secondName);
                    }
                }
            }

        }

        System.out.println(SET.size());

    }

}
