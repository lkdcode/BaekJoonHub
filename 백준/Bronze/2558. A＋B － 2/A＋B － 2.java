import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int firstNumber = Integer.parseInt(bf.readLine());
        int secondNumber = Integer.parseInt(bf.readLine());
        System.out.println(firstNumber + secondNumber);

    }
}