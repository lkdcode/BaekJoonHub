import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        String[] map = new String[size];

        for (int i = 0; i < size; i++) {
            map[i] = br.readLine();
        }

        int row = 0;
        int column = 0;

        for (int i = 0; i < size; i++) {
            String check = "";
            for (int j = 0; j < size; j++) {
                String input = String.valueOf(map[i].charAt(j));
                if (input.equals("X")) {
                    if (check.contains("..")) {
                        row++;
                    }
                    check = "";
                }
                check += input;
            }
            if (check.contains("..")) {
                row++;
            }
        }

        for (int i = 0; i < size; i++) {
            String check = "";
            for (int j = 0; j < size; j++) {
                String input = String.valueOf(map[j].charAt(i));
                if (input.equals("X")) {
                    if (check.contains("..")) {
                        column++;
                    }
                    check = "";
                }
                check += input;
            }
            if (check.contains("..")) {
                column++;
            }
        }

        System.out.println(row + " " + column);


    }
}
