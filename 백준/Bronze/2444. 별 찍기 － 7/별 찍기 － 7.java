import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int startIndex = 0; // 0
        int endIndex = (2 * n - 1) - 1; // 8

        String[] arr = new String[2 * n - 1];
        Arrays.fill(arr, "");

        for (int i = 1; i < n; i++) {

            for (int j = n - i; j > 0; j--) {
                arr[startIndex] += " "; // 0
                arr[endIndex] += " "; // 8
            }

            for (int j = 0; j < 2 * i - 1; j++) {
                arr[startIndex] += "*"; // 0
                arr[endIndex] += "*"; // 8
            }

            startIndex++; // 0 > 1 ...>  4
            endIndex--; // 8 > 7   ...>  5
        }

        for (int i = 0; i < 2 * n - 1; i++) {
            arr[n - 1] += "*";
        }

        for (String s : arr) {
            System.out.println(s);
        }

    }
}
