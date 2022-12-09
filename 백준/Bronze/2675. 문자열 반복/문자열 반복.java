import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int inputSize = Integer.parseInt(bf.readLine());

        List<String> inputWord = new ArrayList<>();
        for (int i = 0; i < inputSize; i++) {
            inputWord.add(bf.readLine());
        }

        List<String> result = new ArrayList<>();
        List<Integer> roof = new ArrayList<>();

        for (int i = 0; i < inputWord.size(); i++) {
            String add = "";
            roof.add(Integer.parseInt(String.valueOf(inputWord.get(i).charAt(0))));
            for (int j = 1; j < inputWord.get(i).length(); j++) {
                if (inputWord.get(i).charAt(j) != ' ') {
                    add += String.valueOf(inputWord.get(i).charAt(j));
                }
            }
            result.add(add);
        }

        for (int i = 0; i < roof.size(); i++) {
            for (int j = 0; j < result.get(i).length(); j++) {
                for (int k = 0; k < roof.get(i); k++) {
                    System.out.print(result.get(i).charAt(j));
                }
            }
            System.out.println();
        }
    }
}