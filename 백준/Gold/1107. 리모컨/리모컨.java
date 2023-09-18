import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final boolean[] errerButton = new boolean[10];

    public static void main(String[] args) throws IOException {

        int findChannel = Integer.parseInt(br.readLine());

        int caseSize = Integer.parseInt(br.readLine());
        if (caseSize > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < caseSize; i++) {
                errerButton[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int result = Math.abs(100 - findChannel);

        for (int i = 0; i <= 1_000_000; i++) {
            String number = Integer.toString(i);
            int check = check(number);

            if (check == -1) continue;
            int cal = Math.abs(findChannel - check);
            result = Math.min(result, cal + number.length());
        }

        System.out.println(result);

    }

    private static int check(String number) {
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char check = number.charAt(i);

            if (errerButton[check - '0']) {
                return -1;
            }
        }

        return Integer.parseInt(number);
    }

}
