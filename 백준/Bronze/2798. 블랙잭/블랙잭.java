import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> list = new ArrayList<>();
    private static int findResult = 0;

    public static void main(String[] args) throws IOException {
        makeInput();

        List<Integer> addList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int firstNumber = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int secondNumber = list.get(j);
                for (int k = j + 1; k < list.size(); k++) {
                    int thirdNumber = list.get(k);
                    addList.add(firstNumber + secondNumber + thirdNumber);
                }
            }
        }


        if (addList.contains(findResult)) {
            System.out.println(findResult);
        }

        if (!(addList.contains(findResult))) {

            for (int i = 0; i <= findResult; i++) {
                int minusNumber = findResult - i;

                if (addList.contains(minusNumber)) {
                    System.out.println(minusNumber);
                    break;
                }

            }



        }

    }

    private static void makeInput() throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");

        int size = Integer.parseInt(inputSplit[0]);
        findResult = Integer.parseInt(inputSplit[1]);

        String secondInput = bf.readLine();
        String[] secondInputSplit = secondInput.split(" ");

        for (int i = 0; i < size; i++) {
            list.add(Integer.valueOf(secondInputSplit[i]));
        }

    }
}
