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

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0 && z == 0) {
                return;
            }

            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            list.add(z);
            Collections.sort(list);

            if (list.get(0) + list.get(1) <= list.get(2)) {
                System.out.println("Invalid");
                continue;
            }


            if (x == y && y == z) {
                System.out.println("Equilateral");
                continue;
            }

            if (x == y || y == z || x == z) {
                System.out.println("Isosceles");
                continue;
            }


            System.out.println("Scalene");

        }

    }

}
