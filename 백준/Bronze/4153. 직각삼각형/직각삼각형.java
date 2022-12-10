import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// class Main으로 수정
public class Main {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        while (true) {
            List<Integer> number;
            number = input();

            int firstNumber = (int) (Math.pow(number.get(0), 2));
            int secondNumber = (int) (Math.pow(number.get(1), 2));
            int thirdNumber = (int) (Math.pow(number.get(2), 2));

            if (firstNumber + secondNumber + thirdNumber == 0) {
                break;
            }

            if (firstNumber + secondNumber == thirdNumber) {
                result.add("right");
                continue;
            }

            if (secondNumber + thirdNumber == firstNumber) {
                result.add("right");
                continue;
            }

            if (thirdNumber + firstNumber == secondNumber) {
                result.add("right");
                continue;
            }


            result.add("wrong");

        }

        for (String view : result) {
            System.out.println(view);
        }

    }

    private static List<Integer> input() {
        String input = SCAN.nextLine();
        String[] inputSplit = input.split(" ");
        List<Integer> number = new ArrayList<>();
        number.add(Integer.parseInt(inputSplit[0]));
        number.add(Integer.parseInt(inputSplit[1]));
        number.add(Integer.parseInt(inputSplit[2]));
        return number;
    }

}