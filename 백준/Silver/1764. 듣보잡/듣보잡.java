import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputSize = br.readLine().split(" ");
        int firstSize = Integer.parseInt(inputSize[0]);
        int secondSize = Integer.parseInt(inputSize[1]);


        Map<String, Integer> firstNames = new HashMap<>();

        for (int i = 0; i < firstSize; i++) {
            firstNames.put(br.readLine(), 0);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < secondSize; i++) {
            String input = br.readLine();
            if (firstNames.containsKey(input)) {
                result.add(input);
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        StringBuilder printResult = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            printResult.append(result.get(i));
            if (i != result.size() - 1) {
                printResult.append("\n");
            }
        }
        System.out.println(printResult);
    }
}