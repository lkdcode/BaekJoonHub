import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final List<String> COLOR = Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");

    public static void main(String[] args) throws IOException {

        String firstColor = bf.readLine();
        String secondColor = bf.readLine();
        String thirdColor = bf.readLine();

        String result = "";

        for (int i = 0; i < COLOR.size(); i++) {
            if (Objects.equals(COLOR.get(i), firstColor)) {
                result += i;
                break;
            }
        }

        for (int i = 0; i < COLOR.size(); i++) {
            if (Objects.equals(COLOR.get(i), secondColor)) {
                result += i;
                break;
            }
        }

        long answer = Long.parseLong(result);

        for (int i = 0; i < COLOR.size(); i++) {
            if (Objects.equals(COLOR.get(i), thirdColor)) {
                long multiple = (long) Math.pow(10, i);
                answer *= multiple;
            }
        }

        System.out.println(answer);

    }
}
