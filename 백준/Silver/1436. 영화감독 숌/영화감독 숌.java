import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int findNumber = Integer.parseInt(bf.readLine());

        String find = "666";
        int count = 0;
        int result = 0;


        int i = 1;
        while (true) {
            String change = String.valueOf(i);
            if (change.contains(find)) {
                count++;
            }
            if (count == findNumber) {
                result = i;
                break;
            }

            i++;
        }

        System.out.println(result);

    }
}