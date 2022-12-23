import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        String[] inputSplit = input.split(" ");

        int hour = Integer.parseInt(inputSplit[0]);
        int minute = Integer.parseInt(inputSplit[1]);
        int second = Integer.parseInt(inputSplit[2]);

        int inputSecond = Integer.parseInt(bf.readLine());

        second += inputSecond;

        minute += second / 60;
        second %= 60;

        hour += minute / 60;
        minute %= 60;
        hour %= 24;

        System.out.println(hour + " " + minute + " " + second);


    }
}