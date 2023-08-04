import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());

        Map<String, String> list = new HashMap<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String commute = st.nextToken();

            if (commute.equals("enter")) {
                list.put(name, "1");
            } else {
                list.remove(name);
            }
        }

        List<String> nameList = new ArrayList<>(list.keySet());
        nameList.sort(Collections.reverseOrder());
        nameList.forEach(System.out::println);
    }

}
