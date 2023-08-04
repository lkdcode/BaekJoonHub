import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int checkX = Integer.parseInt(st.nextToken());
            int checkY = Integer.parseInt(st.nextToken());
            maxX = Math.max(checkX, maxX);
            minX = Math.min(checkX, minX);

            maxY = Math.max(checkY, maxY);
            minY = Math.min(checkY, minY);
        }

        System.out.println(Math.abs((maxX - minX) * (maxY - minY)));

    }

}
