import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        long size = Long.parseLong(st.nextToken());
        long memberSize = Long.parseLong(st.nextToken());

        long[] counter = new long[(int) size];

        long max = 0;

        for (int i = 0; i < size; i++) {
            counter[i] = Long.parseLong(br.readLine());
            max = Math.max(counter[i], max);
        }

        long startIndex = 1;
        long endIndex = max * memberSize;
        long result = 0;

        while (startIndex <= endIndex) {
            long midIndex = (startIndex + endIndex) / 2;

            if (isPossible(size, midIndex, counter, memberSize)) {
                result = midIndex;
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }


        out.println(result);
    }

    private static boolean isPossible(long size, long midIndex, long[] counter, long memberSize) {
        for (int i = 0; i < size; i++) {
            memberSize -= midIndex / counter[i];
            if (memberSize <= 0) return true;
        }

        return false;
    }

}
