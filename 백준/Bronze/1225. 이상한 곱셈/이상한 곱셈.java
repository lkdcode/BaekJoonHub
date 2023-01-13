import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputSplit = input.split(" ");

        List<Integer> firstNumbers = new ArrayList<>();
        List<Integer> secondNumbers = new ArrayList<>();

        for (int i = 0; i < inputSplit[0].length(); i++) {
            firstNumbers.add(Integer.parseInt(String.valueOf(inputSplit[0].charAt(i))));
        }
        for (int i = 0; i < inputSplit[1].length(); i++) {
            secondNumbers.add(Integer.parseInt(String.valueOf(inputSplit[1].charAt(i))));
        }

        long result = 0;
        for (int i = 0; i < firstNumbers.size(); i++) {
            for (int j = 0; j < secondNumbers.size(); j++) {
                result += firstNumbers.get(i) * secondNumbers.get(j);
            }
        }
        System.out.println(result);
    }
}
