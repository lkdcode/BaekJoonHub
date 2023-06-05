import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[] sheet;
    private static int[] playResult;
    private static int[] sheetSum;

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());
        sheet = new int[size + 1];
        playResult = new int[size + 1];
        sheetSum = new int[size + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            sheet[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= size; i++) {
            if (sheet[i] < sheet[i - 1]) {
                playResult[i] = 1;
            }
        }

        for (int i = 1; i <= size; i++) {
            sheetSum[i] = sheetSum[i - 1] + playResult[i];
        }

        int caseSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            if (startIndex == endIndex) {
                System.out.println(0);
                continue;
            }
            System.out.println(sheetSum[endIndex] - sheetSum[startIndex]);

        }

    }

}
