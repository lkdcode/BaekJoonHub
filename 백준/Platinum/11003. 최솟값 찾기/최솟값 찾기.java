import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int checkIndex = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayDeque<WindowSliding> windowNumbers = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int checkNumber = Integer.parseInt(st.nextToken());

            while (!windowNumbers.isEmpty() && windowNumbers.getLast().number > checkNumber) {
                windowNumbers.removeLast();
            }

            while (!windowNumbers.isEmpty() && windowNumbers.getFirst().index <= i - checkIndex) {
                windowNumbers.removeFirst();
            }

            windowNumbers.addLast(new WindowSliding(checkNumber, i));

            result.append(windowNumbers.getFirst().number).append(" ");
        }

        System.out.println(result);
    }

    static class WindowSliding {
        public int number;
        public int index;

        public WindowSliding(int number, int index) {
            this.index = index;
            this.number = number;
        }


    }

}
