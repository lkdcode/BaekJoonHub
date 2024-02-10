import java.util.*;
import java.time.LocalDate;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
                Map<String, Integer> termsMap = new HashMap<>();

        for (String term : terms) {
            String[] split = term.split(" ");
            termsMap.put(split[0], (Integer.parseInt(split[1]) * 28));
        }


        final List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            final String[] split = privacies[i].split(" ");
            final String[] date = split[0].split("\\.");
            final String term = split[1];
            int turmDay = termsMap.get(term);
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]) + turmDay - 1;

            int plusMonth = day / 28;
            day %= 28;

            if (day == 0) {
                day = 28;
                plusMonth--;
            }

            month += plusMonth;

            int plusYear = month / 12;

            month %= 12;
            if (month == 0) {
                month = 12;
                plusYear--;
            }
            year += plusYear;

            String[] todaySplit = today.split("\\.");
            int todayYear = Integer.parseInt(todaySplit[0]);
            int todayMonth = Integer.parseInt(todaySplit[1]);
            int todayDay = Integer.parseInt(todaySplit[2]);

            LocalDate todayLocalDate = LocalDate.of(todayYear, todayMonth, todayDay);
            LocalDate targetLocalDate = LocalDate.of(year, month, day);
            if (todayLocalDate.isAfter(targetLocalDate)) {
                list.add(i + 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}