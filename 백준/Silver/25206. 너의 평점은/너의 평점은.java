import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        double sumScore = 0;
        double sum = 0;

        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            double score = Double.parseDouble(input[1]);
            String grade = input[2];


            if (grade.equals("P")) {
                continue;
            }

            double gradeScore = 0;

            switch (grade) {
                case "A+":
                    gradeScore = 4.5;
                    break;
                case "A0":
                    gradeScore = 4.0;
                    break;
                case "B+":
                    gradeScore = 3.5;
                    break;
                case "B0":
                    gradeScore = 3.0;
                    break;
                case "C+":
                    gradeScore = 2.5;
                    break;
                case "C0":
                    gradeScore = 2.0;
                    break;
                case "D+":
                    gradeScore = 1.5;
                    break;
                case "D0":
                    gradeScore = 1.0;
                    break;
                case "F":
                    gradeScore = 0.0;
                    break;
            }

            sum += (gradeScore * score);
            sumScore += score;
        }

        System.out.println(sum / sumScore);
    }
}
