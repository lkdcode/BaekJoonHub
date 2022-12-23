import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");

        int size = Integer.parseInt(inputSplit[0]) * Integer.parseInt(inputSplit[1]);

        String secondInput = bf.readLine();
        String[] secondInputSplit = secondInput.split(" ");

        List<Integer> validate = new ArrayList<>();

        for (int i = 0; i < secondInputSplit.length; i++) {
            validate.add(Integer.valueOf(secondInputSplit[i]));
        }

        String result = new String();

        for (int i = 0; i < validate.size(); i++) {
            result += (validate.get(i) - size) + " ";
        }

        System.out.println(result.trim());

    }
}