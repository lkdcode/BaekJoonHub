import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");
        double monster = Double.parseDouble(inputSplit[0]);
        double attack = Double.parseDouble(inputSplit[1]);

        double result = monster - (monster * (attack / 100));

        if (result >= 100) {
            System.out.println(0);
        }

        if (result < 100) {
            System.out.println(1);
        }


    }
}