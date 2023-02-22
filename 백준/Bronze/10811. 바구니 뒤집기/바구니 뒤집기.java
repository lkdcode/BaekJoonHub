import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int change = Integer.parseInt(st.nextToken());

        int[] numbers = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            numbers[i] = i;
        }

        for (int i = 0; i < change; i++) {
            st = new StringTokenizer(br.readLine());
            int firstIndex = Integer.parseInt(st.nextToken());
            int lastIndex = Integer.parseInt(st.nextToken());

            numbers = changeNumbers(numbers, firstIndex, lastIndex);
        }

        for (int i = 1; i <= size; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    //        5 4
    //        1 2
    //        3 4
    //        1 4
    //        2 2

    // 1 2 3 4 5
    // 2 1 3 4 5
    // 2 1 4 3 5
    // 3 4 1 2 5


    static int[] changeNumbers(int[] numbers, int firstIndex, int lastIndex) {
        if (firstIndex - lastIndex == 0) {
            return numbers;
        }

        int[] newNumbers = new int[numbers.length];

        for (int i = 0; i < newNumbers.length; i++) {
            newNumbers[i] = numbers[i];
        }

        for (int i = lastIndex, j = firstIndex; i >= firstIndex; i--, j++) {
            newNumbers[j] = numbers[i];
        }

        return newNumbers;
    }


}
