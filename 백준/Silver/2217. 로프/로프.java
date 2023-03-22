import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        List<Integer> lope = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            lope.add(Integer.parseInt(br.readLine()));
        }

        lope.sort(Collections.reverseOrder());

        int result = -1;

        for (int i = 0; i < size; i++) {
            int kg = lope.get(i) * (i + 1);
            result = Math.max(kg, result);
        }

        System.out.println(result);
    }
}
