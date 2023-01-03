import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        ...4
//        ..4.
//        .4..
//        4...
        String input = br.readLine();
        String[] inputSplit = input.split(" ");
        int row = Integer.parseInt(inputSplit[0]);
        int column = Integer.parseInt(inputSplit[1]);

        String[] tower = new String[row];

        for (int i = 0; i < row; i++) {
            tower[i] = br.readLine();
        }

        int rowCount = 0;
        for (int i = 0; i < row; i++) {
            String find = tower[i];
            if (!find.contains("X")) {
                rowCount++;
            }
        }

        int columnCount = 0;
        for (int i = 0; i < column; i++) {
            String find = new String();
            for (int j = 0; j < row; j++) {
                find += tower[j].charAt(i);
            }
            if (!find.contains("X")) {
                columnCount++;
            }
        }
        System.out.println(Math.max(columnCount, rowCount));
    }
}
