import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int inputSize = Integer.parseInt(br.readLine());
            Map<String, Integer> items = new HashMap<>();
            for (int j = 0; j < inputSize; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String itemName = st.nextToken();
                String type = st.nextToken();

                if (items.containsKey(type)) {
                    int number = items.get(type);

                    items.put(type, number + 1);
                    continue;
                }

                items.put(type, 1);
            }
            result(items);
        }
    }


    private static void result(Map<String, Integer> items) {
        int number = 1;

        for (String key : items.keySet()) {
            number *= ((items.get(key)) + 1);
        }

        System.out.println(number - 1);
    }
}
