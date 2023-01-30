import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int quantity = Integer.parseInt(br.readLine());

        String inputData = br.readLine();
        String[] inputDataSplit = inputData.split(" ");

        long memory = Long.parseLong(br.readLine());

        long result = 0;

        for (int i = 0; i < quantity; i++) {
            long data = Long.parseLong(inputDataSplit[i]);

            if (data != 0) {
                result += memoryCalculator(data, memory);
            }
        }

        System.out.println(result);

    }

    private static long memoryCalculator(long data, long memorySize) {
        long memory = memorySize;
        if (data <= memorySize) {
            return memory;
        } else {
            memory = ((data / memorySize) * memorySize);
            if (((data % memorySize)) > memorySize) {
                memory += ((data % memorySize) * memorySize);
            } else if (((data % memorySize)) > 0) {
                memory += memorySize;
            }
            return memory;
        }

    }
}