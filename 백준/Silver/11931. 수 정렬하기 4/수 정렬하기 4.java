import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] arr;
    private static int[] tmp;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        arr = new int[size];
        tmp = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, size - 1);

        for (int i = 0; i < arr.length; i++) {
            bw.write(Integer.toString(arr[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
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
            if (arr[left] >= arr[right]) {
                tmp[index++] = arr[left++];
            } else {
                tmp[index++] = arr[right++];
            }
        }

        while (left <= midIndex) {
            tmp[index++] = arr[left++];
        }

        while (right <= endIndex) {
            tmp[index++] = arr[right++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = tmp[i];
        }


    }


}
