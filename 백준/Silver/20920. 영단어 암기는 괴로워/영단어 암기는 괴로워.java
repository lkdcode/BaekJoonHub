import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < T; i++) {
            String word = br.readLine();
            if (word.length() < min) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entry = new ArrayList<>(map.entrySet());

        entry.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {

                if (e1.getKey().length() == e2.getKey().length()) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return Integer.compare(e2.getKey().length(), e1.getKey().length());
            }
            // count 가 다르고 렝스가 다르고
            return Integer.compare(e2.getValue(), e1.getValue());
        });

        entry.forEach(e -> sb.append(e.getKey()).append(System.lineSeparator()));

        System.out.println(sb);

    }

}
