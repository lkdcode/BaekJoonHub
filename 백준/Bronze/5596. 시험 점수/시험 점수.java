import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String firstStudent = bf.readLine();
        String secondStudent = bf.readLine();

        String[] firstStudentSplit = firstStudent.split(" ");
        String[] secondStudentSplit = secondStudent.split(" ");

        int firstScore = 0;
        int secondScore = 0;

        for (String input : firstStudentSplit) {
            firstScore += Integer.parseInt(input);
        }

        for (String input : secondStudentSplit) {
            secondScore += Integer.parseInt(input);
        }

        System.out.println(Math.max(firstScore, secondScore));

    }
}