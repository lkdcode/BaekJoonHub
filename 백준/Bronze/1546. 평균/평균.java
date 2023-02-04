import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 1. 과목 수 입력 받기 -> validateSize
 * 2. 과목 점수 입력 받기 -> validateListBySize
 * 3. 과목의 최고 점수 구하기
 * 4. 새로운 과목 점수 구하기
 * ...... (기존 점수 / 최고 점수 * 100 -> 새로운 점수) / 과목 수
 * 5. 결과값 출력
 */
public class Main {
    private final Solution solution;

    public Main() {
        this.solution = new Solution();
    }

    void menu() throws IOException {
        int size = solution.inputSize();
        List<Integer> subjectScoreList = solution.inputSubjectList(size);
        int maxScore = solution.getMaxScore(subjectScoreList);
        List<Double> newSubjectScoreList = solution.makeSocreList(maxScore, subjectScoreList);
        double result = solution.getResult(newSubjectScoreList);
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().menu();
    }


}


class Solution {
    private final SolutionValidate validate;
    private final BufferedReader bufferedReader;

    public Solution() {
        this.validate = new SolutionValidate();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int inputSize() throws IOException {
        int size = Integer.parseInt(bufferedReader.readLine());
        validate.validateSize(size);

        return size;
    }

    public List<Integer> inputSubjectList(int size) throws IOException {
        List<Integer> subjectList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        while (stringTokenizer.hasMoreTokens()) {
            subjectList.add(Integer.valueOf(stringTokenizer.nextToken()));
        }

        validate.validateListBySize(size, subjectList);

        return subjectList;
    }

    public int getMaxScore(List<Integer> subjectScoreList) {
        Collections.sort(subjectScoreList, Collections.reverseOrder());
        return subjectScoreList.get(0);
    }

    public List<Double> makeSocreList(int maxScore, List<Integer> subjectScoreList) {
        List<Double> newSubjectScoreList = new ArrayList<>();
        for (int i = 0; i < subjectScoreList.size(); i++) {
            newSubjectScoreList.add(getNewScore(maxScore, subjectScoreList.get(i)));
        }
        return newSubjectScoreList;
    }

    public double getNewScore(int maxScore, int subjectScore) {
        double score = (double) subjectScore / maxScore;
        return Math.round(score * 10000) / 100.0;
    }

    public double getResult(List<Double> newSubjectScoreList) {
        double total = 0;
        for (int i = 0; i < newSubjectScoreList.size(); i++) {
            total += newSubjectScoreList.get(i);
        }


        return total / newSubjectScoreList.size();
    }
}

class SolutionValidate {
    private final int MIN_SIZE = 1;
    private final int MAX_SIZE = 1000;
    private final String ERROR_SIZE_MESSAGE = "[ERROR] 숫자의 범위는 1~1000 사이입니다.";
    private final String ERROR_LIST_MESSAGE = "[ERROR] 과목 수가 다릅니다.";

    public void validateSize(int size) {
        if (!(size >= MIN_SIZE && size <= MAX_SIZE)) {
            throw new NumberFormatException(ERROR_SIZE_MESSAGE);
        }
    }

    public void validateListBySize(int size, List<Integer> subjectScoreList) {
        if (size != subjectScoreList.size()) {
            throw new IllegalArgumentException(ERROR_LIST_MESSAGE);
        }
    }
}