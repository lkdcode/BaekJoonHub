import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int cardSize = Integer.parseInt(br.readLine());

        List<Integer> cards = new ArrayList<>();
        String[] inputCard = br.readLine().split(" ");


        for (int i = 0; i < cardSize; i++) {
            cards.add(Integer.parseInt(inputCard[i]));
        }


        int questionSize = Integer.parseInt(br.readLine());

        String[] inputQuestionCard = br.readLine().split(" ");

        Map<Integer, Integer> cardList = new HashMap<>();

        List<Integer> print = new ArrayList<>();
        for (int i = 0; i < questionSize; i++) {
            cardList.put(Integer.parseInt(inputQuestionCard[i]), 0);
            print.add(Integer.valueOf(inputQuestionCard[i]));
        }

        for (int i = 0; i < cards.size(); i++) {
            if (cardList.containsKey(cards.get(i))) {
                Integer input = cardList.get(cards.get(i)) + 1;
                cardList.put(cards.get(i), input);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < print.size(); i++) {
            result.append(cardList.get(print.get(i)));
            if (i != print.size() - 1) {
                result.append(" ");
            }
        }

        System.out.println(result);


    }
}
