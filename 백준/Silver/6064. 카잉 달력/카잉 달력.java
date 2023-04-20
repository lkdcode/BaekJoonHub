import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < testSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int maxX = Integer.parseInt(st.nextToken());
            int maxY = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            result(maxX, maxY, x, y);
        }


    }

    private static void result(int maxX, int maxY, int x, int y) {
        int result = -1;
        int max = (maxX * maxY) / gcd(maxX, maxY);
        int index = 0;

        if (maxX == 1 && maxY == 1) {
            System.out.println(1);
            return;
        }

        if (maxY == y) y = 0;

        while (true) {
            int targetNumber = maxX * index++ + x;

            if (targetNumber % maxY == y) {
                result = targetNumber;
                break;
            }

            if (targetNumber > max) {
                break;
            }
        }

        System.out.println(result);
    }

    private static int gcd(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }

        return gcd(secondNumber, firstNumber % secondNumber);
    }

}
