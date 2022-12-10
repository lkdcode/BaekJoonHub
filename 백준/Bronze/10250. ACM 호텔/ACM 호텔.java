import java.util.Scanner;

// class Main으로 수정
public class Main {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {

        int roof = SCAN.nextInt();

        for (int i = 0; i < roof; i++) {
            int inputH = SCAN.nextInt();
            int inputW = SCAN.nextInt();
            int inputN = SCAN.nextInt();

            System.out.println(result(inputH, inputN, inputW));
        }

    }

    private static int result(int inputH, int inputN, int inputW) {
        int x = 0;

        if (inputN % inputH == 0) {
            x = inputH;
        }

        if (inputN % inputH != 0) {
            x = inputN % inputH;
        }

        x *= 100;


        int y = 1;
        while (inputH < inputN) {
            y++;
            inputN -= inputH;
        }
        
        return x + y;
    }


}