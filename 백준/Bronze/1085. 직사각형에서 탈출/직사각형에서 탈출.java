import java.util.Scanner;


public class Main {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final int[] START_POINT = {0, 0};

    public static void main(String[] args) {

        String input = SCAN.nextLine();
        String[] point = input.split(" ");

        int[] user = new int[2];
        int[] square = new int[2];

        user[0] = Integer.parseInt(point[0]);
        user[1] = Integer.parseInt(point[1]);

        square[0] = Integer.parseInt(point[2]);
        square[1] = Integer.parseInt(point[3]);

        int a = Math.abs(user[0] - START_POINT[0]);
        int b = Math.abs(user[1] - START_POINT[1]);
        int c = Math.abs(user[0] - square[0]);
        int d = Math.abs(user[1] - square[1]);

        int result = Math.min(Math.min(a, b), Math.min(c, d));

        System.out.println(result);
    }
}