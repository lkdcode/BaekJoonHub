import java.io.*;

import static java.lang.System.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    private static int[] rank;
    private static int[] temp;


    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        rank = new int[size];
        temp = new int[size];

        for (int i = 0; i < size; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, size - 1);

        long result = 0;

        for (int i = 0; i < size; i++) {
            result += Math.abs(rank[i] - (i + 1));
        }

        out.println(result);

    }

    private static void mergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSort(startIndex, midIndex);
            mergeSort(midIndex + 1, endIndex);

            merge(startIndex, midIndex, endIndex);
        }
    }

    private static void merge(int startIndex, int midIndex, int endIndex) {
        int left = startIndex;
        int right = midIndex + 1;
        int index = startIndex;

        while (left <= midIndex && right <= endIndex) {
            if (rank[left] <= rank[right]) {
                temp[index++] = rank[left++];
            } else {
                temp[index++] = rank[right++];
            }
        }

        while (left <= midIndex) {
            temp[index++] = rank[left++];
        }

        while (right <= endIndex) {
            temp[index++] = rank[right++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            rank[i] = temp[i];
        }
    }
}
