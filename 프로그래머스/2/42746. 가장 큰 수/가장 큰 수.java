import java.util.*;

class Solution {
    private static final int[] TARGETS = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public String solution(int[] numbers) {
        final StringBuilder sb = new StringBuilder();
        boolean isOnlyZero = true;

        for (int target : TARGETS) {
            final List<String> list = new ArrayList<>();

            for (int number : numbers) {
                final String str = String.valueOf(number);
                if (str.charAt(0) - '0' == target) {
                    if (target != 0) isOnlyZero = false;
                    list.add(str);
                }
            }

            sort(sb, list);
        }
        
        if(isOnlyZero) {
           return "0";
        } else {
           return sb.toString();
        }
    }
    private static void sort(StringBuilder sb, List<String> list) {
        list.sort((String o1, String o2) -> {
            if (o1.equals(o2)) {
                return 0;
            }
            int o1Number = Integer.parseInt(o1 + o2);
            int o2Number = Integer.parseInt(o2 + o1);

            if (o1Number > o2Number) {
                return -1;
            }
            if (o1Number < o2Number) {
                return 1;
            }

            return 0;
        });
        for (String s : list) {
            sb.append(s);
        }
    }
}