import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(bf.readLine());

        List<Character> members = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String input = bf.readLine();
            members.add(input.charAt(0));
        }

        Collections.sort(members);
        String result = "";

        for (int i = 0; i < members.size(); i++) {
            int count = 0;
            char validate = members.get(i);
            for (int j = i + 1; j < members.size(); j++) {
                if (validate == members.get(j)) {
                    count++;
                }
            }

            if (count == 4 && !result.contains(String.valueOf(validate))) {
                result += validate;
            }
        }

        if (result.length() == 0) {
            System.out.println("PREDAJA");
            return;
        }

        System.out.println(result);

    }
}