import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        double number = scanner.nextDouble();

        System.out.println(number * number * Math.PI);
        System.out.println(number * number * 2);
    }
}
