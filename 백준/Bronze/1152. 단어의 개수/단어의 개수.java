import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
        System.out.println(stringTokenizer.countTokens());
    }
}