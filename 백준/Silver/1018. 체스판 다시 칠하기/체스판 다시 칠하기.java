import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] size = br.readLine().split(" ");

        int row = Integer.parseInt(size[0]);
        int column = Integer.parseInt(size[1]);

        String[] board = new String[row];

        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

////////////////////////////////////////////////////////////
        int rowLoop = row - 7;
        int columnLoop = column - 7;

        int rowStartIndex = 0;
        int columnStartIndex = 0;
        int columnEndIndex = 8;

        int result = Integer.MAX_VALUE;

        for (int k = 0; k < rowLoop; k++) {

            for (int i = 0; i < columnLoop; i++) {
                String[] checkBoard = new String[8];
                int input = 0;
                for (int j = columnStartIndex; j < columnEndIndex; j++) {
                    checkBoard[input] = board[j].substring(rowStartIndex, (rowStartIndex + 8));
                    input++;
                }

                rowStartIndex++;

                result = Math.min(result, getResult(checkBoard));

            }
            rowStartIndex = 0;

            columnStartIndex++;
            columnEndIndex++;
        }

        System.out.println(result);

    }

    private static int getResult(String[] checkBoard) {
        String checkWhite = "WBWBWBWB";
        String checkBlack = "BWBWBWBW";

        int count = 0;
        for (int i = 0; i < 8; i++) {
            String check = checkBoard[i];

            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (checkWhite.charAt(j) != check.charAt(j)) {
                        count++;
                    }
                } else {
                    if (checkBlack.charAt(j) != check.charAt(j)) {
                        count++;
                    }
                }
            }


        }

        return Math.min(count, (64 - count));
    }

}
