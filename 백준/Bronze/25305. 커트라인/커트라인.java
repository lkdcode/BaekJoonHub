import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");
        int win = Integer.parseInt(inputSplit[1]);

        List<Integer> numbers = new ArrayList<>();
        String add = bf.readLine();
        String[] addSplit = add.split(" ");
        for (int i = 0; i < addSplit.length; i++) {
            numbers.add(Integer.valueOf(addSplit[i]));
        }


        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers.get(win - 1));


    }
}