import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(bf.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int input = Integer.parseInt(bf.readLine());
            list.add(input);
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}