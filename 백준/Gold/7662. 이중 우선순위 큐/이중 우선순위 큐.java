import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            makeResult();
        }

        System.out.println(result);
    }

    private static void makeResult() throws IOException {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            if (input.equals("I")) {
                int key = Integer.parseInt(st.nextToken());
                treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
            } else {
                String order = st.nextToken();
                if (order.equals("-1")) {
                    if (treeMap.size() == 0) {
                        continue;
                    }
                    int value = treeMap.get(treeMap.firstKey());

                    if (value == 1) {
                        treeMap.remove(treeMap.firstKey());
                    } else {
                        treeMap.put(treeMap.firstKey(), (value - 1));
                    }
                } else {
                    if (treeMap.size() == 0) {
                        continue;
                    }
                    int value = treeMap.get(treeMap.lastKey());

                    if (value == 1) {
                        treeMap.remove(treeMap.lastKey());
                    } else {
                        treeMap.put(treeMap.lastKey(), (value - 1));
                    }
                }
            }

        }

        if (treeMap.size() == 0) {
            result.append("EMPTY")
                    .append("\n");
            return;
        }

        result.append(treeMap.lastKey())
                .append(" ")
                .append(treeMap.firstKey())
                .append("\n");
    }


}