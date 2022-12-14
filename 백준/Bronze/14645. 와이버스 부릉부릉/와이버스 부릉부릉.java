import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String input = bf.readLine();
        String[] inputSplit = input.split(" ");
        int roof = Integer.parseInt(inputSplit[0]);
        for (int i = 0; i < roof; i++) {
            input = bf.readLine();
        }
        System.out.println("비와이");
    }
}