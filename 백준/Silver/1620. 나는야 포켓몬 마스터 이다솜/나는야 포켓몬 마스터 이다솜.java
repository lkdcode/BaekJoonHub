import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private static Map<String, Integer> namePokemonsters = new HashMap<>();
    private static Map<Integer, String> numberPokemonsters = new HashMap<>();
    private static List<String> questions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputSplit = input.split(" ");

        int pokemons = Integer.parseInt(inputSplit[0]);
        int question = Integer.parseInt(inputSplit[1]);

        inputPokemons(pokemons);
        inputQuestion(question);

        result();
    }

    private static void inputPokemons(int pokemons) throws IOException {


        for (int i = 0; i < pokemons; i++) {
            String pokemon = br.readLine();
            namePokemonsters.put(pokemon, i);
            numberPokemonsters.put(i, pokemon);
        }


    }

    private static void inputQuestion(int question) throws IOException {
        for (int i = 0; i < question; i++) {
            questions.add(br.readLine());
        }
    }

    private static void result() {
        for (int i = 0; i < questions.size(); i++) {
            char isNumber = questions.get(i).charAt(0);

            if (Character.isDigit(isNumber)) {
                numberResult(questions.get(i));
            } else {
                nameResult(questions.get(i));
            }

        }
    }

    private static void nameResult(String findPokemon) {
        System.out.println(namePokemonsters.get(findPokemon) + 1);
    }

    private static void numberResult(String findPokemon) {
        int findPokemonIndex = Integer.parseInt(findPokemon) - 1;
        System.out.println(numberPokemonsters.get(findPokemonIndex));
    }
}
