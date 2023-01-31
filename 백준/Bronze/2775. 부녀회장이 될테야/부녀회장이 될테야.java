import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] APT = makeAPT();
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            result(APT);
        }
    }

    private static void result(int[][] APT) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        System.out.println(APT[k][n]);
    }

    private static int[][] makeAPT() {
        int[][] APT = new int[15][15];

        for (int i = 0; i < APT.length; i++) {
            APT[0][i] = i;
            APT[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {

            for (int j = 2; j < 15; j++) {
                APT[i][j] = APT[i - 1][j] + APT[i][j - 1];
            }

        }

        return APT;
    }

}
