import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int question = scanner.nextInt();
        int count = 1;
        int lineNumber = 1;

        // 1/1
        // 1/2 2/1
        // 짝수는 분자가 커지고
        // 홀수는 분모가 커진다


        // 1  2  2  3  3  3  4  4  4  4 .......
        // 1  2  3  4  5  6  7  8  9  10 .......
        // 1  1  2  1  2  3  1  2  3  4


        out:
        for (int i = 1; i <= question; i++) {

            for (int j = 1; j <= i; j++) {

                if (count == question) {
                    lineNumber = i;
                    count = j;
                    break out;
                }
                count++;
            }
        }

        if (lineNumber % 2 == 0) { // 짝수
            // 분자가 커지고
            // 분모가 작아진다
            int 분자 = 1 + count - 1;
            int 분모 = lineNumber - count + 1;
            System.out.println(분자 + "/" + 분모);
        } else { // 홀수
            // 분모가 커지고
            // 분자가 작아진다
            int 분모 = 1 + count - 1;
            int 분자 = lineNumber - count + 1;
            System.out.println(분자 + "/" + 분모);
        }

    }

}
