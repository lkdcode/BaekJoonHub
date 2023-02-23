import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        String[] start = new String[size];
        String[] end = new String[size];

        // 1 3 5 7
        int startIndex = 0;
        int endIndex = size - 1;
        for (int i = 0; i < size * 2; i += 2) {
            String input = "";
            String space = " ";

            for (int k = 0; k <= i; k++) {
                input += "*";
            }

            start[startIndex++] = input;
            end[endIndex--] = input;
        }

        end[0] = "";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {

            for (int j = size - 1; j > i; j--) {
                result.append(" ");
            }
            result.append(start[i] + "\n");
        }


        for (int i = 0; i < size; i++) {
            if (end[i] != "") {
                for (int j = i; j > 0; j--) {
                    result.append(" ");
                }
                result.append(end[i] + "\n");
            }
        }

        System.out.println(result);


    }

}
//
//    *
//   ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//    *
