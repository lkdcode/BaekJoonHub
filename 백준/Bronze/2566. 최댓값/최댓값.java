import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> input = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            String in = bf.readLine();
            String[] inSplit = in.split(" ");
            List<Integer> add = new ArrayList<>();
            for (int j = 0; j < inSplit.length; j++) {
                add.add(Integer.parseInt(inSplit[j]));
            }
            input.add(add);
        }

        int max = 0;

        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                max = Math.max(input.get(i).get(j), max);
            }
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                if (input.get(i).get(j) == max) {
                    x = i + 1;
                    y = j + 1;
                    break;
                }
            }
        }
        System.out.println(max);
        System.out.println(x + " " + y);


    }
}