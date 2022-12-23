import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());

        for (int i = size; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}