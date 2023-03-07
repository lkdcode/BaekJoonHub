import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[] result = new int[size];

        int startIndex = 0;

        int findIndex = 1;

        // 4 1 6 1 3 6 1 4

        while (startIndex < list.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (findIndex == list.get(i)) {
                    result[i] = startIndex++;
                }
            }

            findIndex++;

        }

        for (int view : result) {
            System.out.print(view + " ");
        }

    }
}
