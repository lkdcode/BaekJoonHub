import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// class Main으로 수정
public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(selfNumber(i));
        }

        Collections.sort(numbers);
        
        for (int i = 1; i <= 10000; i++) {
            if (!(numbers.contains(i))) {
                System.out.println(i);
            }
        }


    }

    private static int selfNumber(int number) {
        String input = String.valueOf(number);
        int self = number;

        if (number < 10) {
            self += number;
            return self;
        }

        if (number >= 10) {
            for (int i = 0; i < input.length(); i++) {
                String add = String.valueOf(input.charAt(i));
                self += Integer.parseInt(add);
            }
        }

        return self;
    }
}