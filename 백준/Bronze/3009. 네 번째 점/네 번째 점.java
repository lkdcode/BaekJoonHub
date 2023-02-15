import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] xCount = new int[1001];
        int[] yCount = new int[1001];

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            int xPoint = Integer.parseInt(input[0]);
            int yPoint = Integer.parseInt(input[1]);
            xCount[xPoint]++;
            yCount[yPoint]++;
        }

        for (int i = 0; i < 1001; i++) {
            if (xCount[i] == 1) {
                System.out.print(i);
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (yCount[i] == 1) {
                System.out.println(" " + i);
            }
        }
    }
}