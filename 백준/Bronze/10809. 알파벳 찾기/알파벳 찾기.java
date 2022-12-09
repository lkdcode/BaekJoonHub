import java.util.*;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);
    private static int[] result = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static void main(String[] args) {
        String input = SCAN.nextLine();
        char[] inputWord = input.toCharArray();
        List<Integer> userInput = new ArrayList<>();

        for (int i = 0; i < inputWord.length; i++) {
            int number = Integer.parseInt(String.valueOf(inputWord[i] - 97));
            userInput.add(number);
        }

        List<Integer> skip = new ArrayList<>();
        for (int i = 0; i < userInput.size(); i++) {
            if (!(skip.contains(userInput.get(i)))) {
                result[userInput.get(i)] = i;
            }
            skip.add(userInput.get(i));
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}