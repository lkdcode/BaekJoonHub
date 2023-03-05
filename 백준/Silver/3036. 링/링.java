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

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < size; i++) {
            int index = list.get(0);
            int gcd = GCD(index, list.get(i));

            System.out.println((index / gcd) + "/" + (list.get(i) / gcd));

        }
    }


    private static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return GCD(b, a % b);
    }
}
