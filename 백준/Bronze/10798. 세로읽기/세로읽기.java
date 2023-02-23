import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[15];

        Arrays.fill(list, "");

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                list[j] += String.valueOf(input.charAt(j));
            }

        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.length; i++) {
            if (list[i].length() != 0) {
                result.append(list[i]);
            }
        }

        System.out.println(result);


    }
}