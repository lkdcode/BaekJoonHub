import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int startIndex = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, size);

        find(row, column, size);

        System.out.println(startIndex);
    }

    private static void find(int row, int column, int size) {
        if (size == 1) return;

        int index = size / 2;

        if (index > row && index > column) {
            // 1사분면
            find(row, column, index);

        } else if (index > row && index <= column) {
            // 2사분면
            startIndex += ((size * size) / 4);

            find(row, column - index, index);

        } else if (index <= row && index > column) {
            // 3사분면
            startIndex += ((size * size) / 4) * 2;

            find(row - index, column, index);

        } else if (index <= row && index <= column) {
            // 4사분면
            startIndex += ((size * size) / 4) * 3;
            find(row - index, column - index, index);
        }

    }

}