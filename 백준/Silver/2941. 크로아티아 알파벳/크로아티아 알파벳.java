import java.util.Scanner;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final String[] CROATIA = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {

        String input = SCAN.nextLine();

        int count = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = 0; j < CROATIA.length; j++) {
                if (input.contains(CROATIA[j])) {
                    input = input.replace(CROATIA[j], " ");
                }
            }
        }

        System.out.println(input.length());

    }
}