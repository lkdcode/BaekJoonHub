import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(bf.readLine());
        int[][] input = new int[size][2];

        for (int i = 0; i < size; i++) {
            String[] inputStr = bf.readLine().split(" ");
            input[i][0] = Integer.parseInt(inputStr[0]);
            input[i][1] = Integer.parseInt(inputStr[1]);
        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i][0] + " " + input[i][1]);
        }

    }
}


