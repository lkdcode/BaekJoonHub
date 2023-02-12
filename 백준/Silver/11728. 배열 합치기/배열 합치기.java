import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int firstSize = Integer.parseInt(input[0]);
        int secondSize = Integer.parseInt(input[1]);


        int[] firstNumbers = new int[firstSize];
        int[] secondNumbers = new int[secondSize];

        input = br.readLine().split(" ");
        for (int i = 0; i < firstSize; i++) {
            firstNumbers[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < secondSize; i++) {
            secondNumbers[i] = Integer.parseInt(input[i]);
        }

        int[] result = new int[firstSize + secondSize];

        int index = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstSize && secondIndex < secondSize) {

            if (firstNumbers[firstIndex] > secondNumbers[secondIndex]) {
                result[index++] = secondNumbers[secondIndex++];
            } else {
                result[index++] = firstNumbers[firstIndex++];
            }

        }

        while (firstIndex < firstSize) {
            result[index++] = firstNumbers[firstIndex++];
        }

        while (secondIndex < secondSize) {
            result[index++] = secondNumbers[secondIndex++];
        }


        StringBuilder resultPrint = new StringBuilder();
        for (int inputNumber : result) {
            resultPrint.append(inputNumber).append(" ");
        }

        System.out.println(resultPrint);

    }
}
