import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());

        for (int i = 0; i < size; i++) {
            String input = bf.readLine();
            System.out.println(input.toLowerCase());
        }
        
    }
}