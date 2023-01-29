import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Double> score = new ArrayList<>();
    private static List<Integer> grade = new ArrayList<>();
    private static List<Double> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int caseSize = Integer.parseInt(br.readLine());
        inputCase(caseSize);
        resultCalculator();
        printResult();
    }

    private static void inputCase(int caseSize) throws IOException {

        for (int i = 0; i < caseSize; i++) {
            int loop = Integer.parseInt(br.readLine());

            calculator(loop);
        }

    }

    private static void calculator(int loop) throws IOException {
        int totalGrade = 0;
        double totalScore = 0;

        for (int i = 0; i < loop; i++) {
            String inputScore = br.readLine();
            String[] inputScoreSplit = inputScore.split(" ");

            totalGrade += Integer.parseInt(inputScoreSplit[0]);

            totalScore += scoreCalculator(Integer.parseInt(inputScoreSplit[0]), Double.parseDouble(inputScoreSplit[1]));
        }

        grade.add(totalGrade);
        score.add(totalScore);

    }

    private static double scoreCalculator(int grade, double score) {
        return grade * score;
    }

    private static void resultCalculator() {
        for (int i = 0; i < score.size(); i++) {
            result.add(score.get(i) / grade.get(i));
        }
    }

    private static void printResult() {
        for (int i = 0; i < score.size(); i++) {
            System.out.printf("%d %.1f", grade.get(i), result.get(i));
            if (i + 1 != score.size()) {
                System.out.println();
            }
        }
    }

}
