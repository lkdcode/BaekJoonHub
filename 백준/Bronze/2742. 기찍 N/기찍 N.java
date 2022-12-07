import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        for (int i = number; i > 0; i--) {
            System.out.println(i);
        }
    }
}