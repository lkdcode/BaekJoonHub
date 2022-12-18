import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static String[][] player;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());
        player = new String[size][2];
        for (int i = 0; i < size; i++) {
            addPlayer(i);
        }
        Arrays.sort(player, new Comparator<>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i = 0; i < player.length; i++) {
            System.out.println(player[i][0] + " " + player[i][1]);
        }

    }

    private static void addPlayer(int i) throws IOException {
        String input = String.valueOf(bf.readLine());
        String[] inputSplit = input.split(" ");
        player[i][0] = inputSplit[0];
        player[i][1] = inputSplit[1];
    }
}