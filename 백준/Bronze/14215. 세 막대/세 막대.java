import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        list.add(z);
        Collections.sort(list);

        x = list.get(0);
        y = list.get(1);
        z = list.get(2);

        if (x + y > z) {
            System.out.println(x + y + z);
            return;
        }

        int total = x + y;
        while (true) {
            if (total > --z) {
                System.out.println(total + z);
                return;
            }
        }

    }

}
