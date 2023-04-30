import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = check(0, 0, size);
        System.out.println(result);
    }

    private static int check(int row, int column, int size) {
        if (size == 1) {
            return map[row][column];
        }

        int newSize = size / 2;

        List<Integer> temp = new ArrayList<>();

        temp.add(check(row, column, newSize));
        temp.add(check(row, column + newSize, newSize));
        temp.add(check(row + newSize, column, newSize));
        temp.add(check(row + newSize, column + newSize, newSize));

        Collections.sort(temp);

        return temp.get(1);
    }

}

//8
//51 58 9 28 50 48 36 42
//52 41 0 20 15 39 7 4
//5 43 18 37 10 8 44 49
//33 31 13 22 26 14 24 40
//46 25 11 45 21 19 32 6
//54 55 29 1 27 23 35 47
//12 56 34 57 61 63 3 2
//17 59 30 53 16 38 62 60