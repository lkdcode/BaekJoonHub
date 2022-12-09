import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final String ASCENDING = "ascending";
    private static final String DESCENDING = "descending";
    private static final String MIXED = "mixed";

    public static void main(String[] args) {

        String input = SCAN.nextLine();
        String[] inputNumber = input.split(" ");

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < inputNumber.length; i++) {
            number.add(Integer.parseInt(inputNumber[i]));
        }

        if (setAscending(number) &&
          setDescending(number)) {
            System.out.println(MIXED);
        }

    }

    private static boolean setAscending(List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size() - 1; i++) {
            if (number.get(i) + 1 == number.get(i + 1)) {
                count++;
            }
        }
        if (count == number.size() - 1) {
            System.out.println(ASCENDING);
            return false;
        }
        return true;
    }


    private static boolean setDescending(List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size() - 1; i++) {
            if (number.get(i) - 1 == number.get(i + 1)) {
                count++;
            }
        }
        if (count == number.size() - 1) {
            System.out.println(DESCENDING);
            return false;
        }
        return true;
    }
}