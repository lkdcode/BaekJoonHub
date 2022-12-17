import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split("");

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < inputSplit.length; i++) {
            result.add(Integer.parseInt(inputSplit[i]));
        }


        Collections.sort(result, Comparator.reverseOrder());

        String answer = new String();
        for (int i = 0; i < result.size(); i++) {
            answer += String.valueOf(result.get(i));
        }

        System.out.println(answer);

    }
}