import java.util.*;

class Solution {
        private static final Map<String, Integer> TABLE_POINTS = new HashMap<>();

    static {
        TABLE_POINTS.put("R", 0);
        TABLE_POINTS.put("T", 0);

        TABLE_POINTS.put("C", 0);
        TABLE_POINTS.put("F", 0);

        TABLE_POINTS.put("J", 0);
        TABLE_POINTS.put("M", 0);

        TABLE_POINTS.put("A", 0);
        TABLE_POINTS.put("N", 0);
    }

    private static final int[] POINTS = new int[]{3, 2, 1, 0, 1, 2, 3};

    
    public String solution(String[] survey, int[] choices) {

        int size = survey.length;

        for (int i = 0; i < size; i++) {
            int choice = choices[i] - 1;
            if (choice == 3) continue;

            String firstSurvey = String.valueOf(survey[i].charAt(0));
            String secondSurvey = String.valueOf(survey[i].charAt(1));

            int point = POINTS[choice];

            if (choice < 3) {
                TABLE_POINTS.put(firstSurvey, TABLE_POINTS.get(firstSurvey) + point);
            } else {
                TABLE_POINTS.put(secondSurvey, TABLE_POINTS.get(secondSurvey) + point);
            }
        }

        String answer = "";

        Integer r = TABLE_POINTS.get("R");
        Integer t = TABLE_POINTS.get("T");

        if (r >= t) {
            answer += "R";
        } else {
            answer += "T";
        }

        Integer c = TABLE_POINTS.get("C");
        Integer f = TABLE_POINTS.get("F");

        if (c >= f) {
            answer += "C";
        } else {
            answer += "F";
        }

        Integer j = TABLE_POINTS.get("J");
        Integer m = TABLE_POINTS.get("M");

        if (j >= m) {
            answer += "J";
        } else {
            answer += "M";
        }

        Integer a = TABLE_POINTS.get("A");
        Integer n = TABLE_POINTS.get("N");

        if (a >= n) {
            answer += "A";
        } else {
            answer += "N";
        }

        return answer;
    }
}