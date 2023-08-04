import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer inputNumbers = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            int menu = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(inputNumbers.nextToken());

            if (menu == 0) {
                deque.add(number);
            }

        }

        size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(st.nextToken());
            deque.addFirst(number);

            sb.append(deque.pollLast() + " ");
        }

        System.out.println(sb);

    }

}
