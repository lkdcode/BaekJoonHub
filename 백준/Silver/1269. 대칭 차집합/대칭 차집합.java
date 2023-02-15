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
        String[] input = br.readLine().split(" ");

        int firstSize = Integer.parseInt(input[0]);
        int secondSize = Integer.parseInt(input[1]);

        Map<Integer, Integer> firstNumbers = new HashMap<>();
        Map<Integer, Integer> secondNumbers = new HashMap<>();

        List<Integer> findFirstNumber = new ArrayList<>();
        List<Integer> findSecondNumber = new ArrayList<>();

        input = br.readLine().split(" ");
        for (int i = 0; i < firstSize; i++) {
            Integer number = Integer.parseInt(input[i]);
            firstNumbers.put(number, 0);
            findSecondNumber.add(number);
        }


        input = br.readLine().split(" ");
        for (int i = 0; i < secondSize; i++) {
            Integer number = Integer.parseInt(input[i]);
            secondNumbers.put(number, 0);
            findFirstNumber.add(number);
        }



        for (int i = 0; i < findSecondNumber.size(); i++) {
            Integer number = findSecondNumber.get(i);
            secondNumbers.remove(number);
        }


        for (int i = 0; i < findFirstNumber.size(); i++) {
            Integer number = findFirstNumber.get(i);
            firstNumbers.remove(number);
        }

        int result = firstNumbers.size() + secondNumbers.size();

        System.out.println(result);
    }
}
