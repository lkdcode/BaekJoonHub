import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Result {
    public String make(int a, int b);
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Result result = new Result() {
            @Override
            public String make(int a, int b) {
                if (a > b) {
                    return ">";
                } else if (a < b) {
                    return "<";
                } else {
                    return "==";
                }
            }


        };

        String input = br.readLine();
        String[] inputSplit = input.split(" ");
        int firstNumber = Integer.parseInt(inputSplit[0]);
        int secondNumber = Integer.parseInt(inputSplit[1]);

        System.out.println(result.make(firstNumber, secondNumber));

    }
}
