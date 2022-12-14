import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();

        HashMap<String, String> point = new HashMap<>();
        point.put("A+", "4.3");
        point.put("A0", "4.0");
        point.put("A-", "3.7");
        point.put("B+", "3.3");
        point.put("B0", "3.0");
        point.put("B-", "2.7");
        point.put("C+", "2.3");
        point.put("C0", "2.0");
        point.put("C-", "1.7");
        point.put("D+", "1.3");
        point.put("D0", "1.0");
        point.put("D-", "0.7");
        point.put("F", "0.0");

        System.out.println(point.get(input));
    }
}