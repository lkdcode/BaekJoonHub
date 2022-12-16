import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());
        StringBuilder result = new StringBuilder();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i)).append('\n');
        }

        System.out.print(result);

    }
}