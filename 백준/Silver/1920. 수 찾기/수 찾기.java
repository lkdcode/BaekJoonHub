import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int firstSize = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        Collections.sort(numbers);

        int secondSize = Integer.parseInt(br.readLine());
        List<Integer> findNumbers = new ArrayList<>();
        input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            findNumbers.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < secondSize; i++) {
            int index = firstSize / 2;
            int findNumber = findNumbers.get(i);

            find(index, findNumber, numbers);
        }


    }

    static void find(int index, int findNumber, List<Integer> numbers) {
        if (numbers.get(index) == findNumber) {
            System.out.println("1");
            return;
        }

        if (numbers.size() <= 10) {
            result(findNumber, numbers);
            return;
        }

        List<Integer> newNumbers = new ArrayList<>();

        if (numbers.get(index) < findNumber) {
            newNumbers = numbers.subList(index, numbers.size());
        } else if (numbers.get(index) > findNumber) {
            newNumbers = numbers.subList(0, index);
        }

        int newIndex = newNumbers.size() / 2;
        find(newIndex, findNumber, newNumbers);
    }

    static void result(int findNumber, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == findNumber) {
                System.out.println("1");
                return;
            }
        }

        System.out.println("0");
    }
}
