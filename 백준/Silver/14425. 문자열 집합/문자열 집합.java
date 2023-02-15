import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputSize = br.readLine().split(" ");
        int checkSize = Integer.parseInt(inputSize[0]);
        int questionSize = Integer.parseInt(inputSize[1]);

        Map<String, String> check = new HashMap<>();
        int result = 0;

        for (int i = 0; i < checkSize; i++) {
            check.put(br.readLine(), "0");
        }

        for (int i = 0; i < questionSize; i++) {
            if (check.containsKey(br.readLine())) {
                result++;
            }
        }


        System.out.println(result);

    }
}
