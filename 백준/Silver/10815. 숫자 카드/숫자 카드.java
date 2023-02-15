import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int resultSize = Integer.parseInt(br.readLine());
        Map<Integer, Integer> resultMap = new HashMap<>();

        String[] inputResult = br.readLine().split(" ");

        for (int i = 0; i < resultSize; i++) {
            int number = Integer.parseInt(inputResult[i]);
            resultMap.put(number, number);
        }

        int questionSize = Integer.parseInt(br.readLine());
        String[] inputQuestion = br.readLine().split(" ");

        StringBuilder resultPrint = new StringBuilder();

        for (int i = 0; i < questionSize; i++) {
            int number = Integer.parseInt(inputQuestion[i]);

            if (resultMap.get(number) != null) {
                resultPrint.append("1");
            } else {
                resultPrint.append("0");
            }
            if (i != questionSize - 1) {
                resultPrint.append(" ");
            }

        }
        System.out.println(resultPrint);


    }
}
