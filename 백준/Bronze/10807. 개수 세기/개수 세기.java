import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// class Main으로 수정
public class Main {
    private static final BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String roof = BF.readLine();
        String inputNumbers = BF.readLine();
        String inputFindNumber = BF.readLine();

        String[] numbers = inputNumbers.split(" ");
        int findNumber = Integer.parseInt(inputFindNumber);

        List<Integer> totalNumbers = new ArrayList<>();
        for (String str : numbers) {
            totalNumbers.add(Integer.parseInt(str));
        }

        int count = 0;
        for (int i = 0; i < totalNumbers.size(); i++) {
            if (totalNumbers.get(i) == findNumber) {
                count++;
            }
        }
        System.out.println(count);

    }
}