import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] inputSplit = input.split(" ");

        String a = inputSplit[0];
        String b = inputSplit[1];

        String numberA = "";
        String numberB = "";

        for (int i = 2; i >= 0; i--) {
            numberA += a.charAt(i);
            numberB += b.charAt(i);
        }

        int firstNumber = Integer.parseInt(numberA);
        int secondNumber = Integer.parseInt(numberB);

        if (firstNumber > secondNumber) {
            System.out.println(firstNumber);
        }

        if (firstNumber < secondNumber) {
            System.out.println(secondNumber);
        }

    }
}