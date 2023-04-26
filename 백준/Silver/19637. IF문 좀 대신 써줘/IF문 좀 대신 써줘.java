import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.System.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int titleSize = Integer.parseInt(st.nextToken());
        int playerSize = Integer.parseInt(st.nextToken());

        Map<Integer, String> titles = new LinkedHashMap<>();

        for (int i = 0; i < titleSize; i++) {
            st = new StringTokenizer(br.readLine());
            String titleName = st.nextToken();
            int point = Integer.parseInt(st.nextToken());

            if (titles.containsKey(point)) continue;

            titles.put(point, titleName);
        }

        int size = titles.values().size();

        int[] pointList = new int[size];
        String[] titleList = new String[size];

        int index = 0;
        for (Integer point : titles.keySet()) {
            pointList[index++] = point;
        }

        for (int i = 0; i < playerSize; i++) {
            int playerPoint = Integer.parseInt(br.readLine());

            int startIndex = 0;
            int endIndex = size - 1;
            while (startIndex <= endIndex) {
                int moveIndex = (startIndex + endIndex) / 2;
                if (playerPoint > pointList[moveIndex]) startIndex = moveIndex + 1;
                else endIndex = moveIndex - 1;
            }

            bw.write(titles.get(pointList[startIndex]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}