import java.util.*;

// class Main으로 수정
public class Main {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {

        String input = SCAN.nextLine();
        int size = Integer.parseInt(input);
        HashMap<String, Integer> inputs = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String word = SCAN.nextLine();
            inputs.put(word, word.length());
        }

        List<Map.Entry<String, Integer>> sorting = new LinkedList<>(inputs.entrySet());
        sorting.sort(Map.Entry.comparingByKey());
        sorting.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : sorting) {
            System.out.println(entry.getKey());
        }


    }
}