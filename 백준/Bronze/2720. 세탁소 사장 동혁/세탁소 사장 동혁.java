import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final double[] CHANGE_AMOUNT = {0.25, 0.10, 0.05, 0.01};

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            double question = Integer.parseInt(br.readLine()) / 100.0;
            int[] result = new int[4];

            for (int j = 0; j < CHANGE_AMOUNT.length; j++) {
                int count = (int) (question / CHANGE_AMOUNT[j]);
                question %= CHANGE_AMOUNT[j];
                question = Math.round(question * 100D) / 100D;

                result[j] = count;
            }

            for (int i1 : result) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }

    }

}
