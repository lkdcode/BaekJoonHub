import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());

        String result = new String();

        List<String> input = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            input.add(bf.readLine());
        }

        boolean isSame = true;

        for (int i = 0; i < input.get(0).length(); i++) {
            char word = input.get(0).charAt(i);
            isSame = true;
            for (int j = 1; j < size; j++) {
                if (input.get(j).charAt(i) != word) {
                    isSame = false;
                    break;
                }

            }
            if (isSame) {
                result += input.get(0).charAt(i);
            }
            if (!isSame) {
                result += "?";
            }

        }
        System.out.println(result);
    }
}