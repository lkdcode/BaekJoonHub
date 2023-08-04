import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());

        if (x == 60 && y == 60 && z == 60) {
            System.out.println("Equilateral");
            return;
        }

        int total = x + y + z;

        if (total != 180) {
            System.out.println("Error");
            return;
        }

        if (x == y || y == z || x == z) {
            System.out.println("Isosceles");
            return;
        }

        System.out.println("Scalene");


    }

}
