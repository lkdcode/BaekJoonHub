import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String input = bf.readLine();
        String[] inputSplit = input.split(" ");

        while (true) {
            if (inputSplit[0].equals("0") && inputSplit[1].equals("0")) {
                break;
            }
            System.out.println(Integer.parseInt(inputSplit[0]) + Integer.parseInt(inputSplit[1]));
            input = bf.readLine();
            inputSplit = input.split(" ");
        }

    }
}