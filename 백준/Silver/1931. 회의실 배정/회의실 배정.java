import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        int[][] timeList = new int[size][2];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                timeList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(timeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    if (o1[0] > o2[0]) {
                        return 1;
                    } else if (o1[0] < o2[0]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        int result = 1;

        int index = timeList[0][1];

        for (int i = 1; i < timeList.length; i++) {
            int startTime = timeList[i][0];
            int endTime = timeList[i][1];

            if (index <= startTime) {
                index = endTime;
                result++;
            }

        }

        System.out.println(result);
    }

}
