import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");

        int num1 = Integer.parseInt(inputSplit[0]);
        int num2 = Integer.parseInt(inputSplit[1]);

        int result1 = num2 - num1;
        int result2 = num2;

        System.out.println(result1 + " " + result2);


    }
}