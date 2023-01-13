import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        Queue<Integer> numbers = new LinkedList<>();

        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        while (numbers.size() != 1) {
            numbers.remove();
            numbers.add(numbers.poll());
        }

        System.out.println(numbers.poll());
    }
}
