import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
      char[] chars = my_str.toCharArray();
        List<String> list = new ArrayList<>();

        String str = "";

        for (int i = 0; i < chars.length; i++) {
            str += chars[i];
            if (str.length() == n) {
                list.add(str);
                str = "";
            }
        }

        if (!(str.equals(""))) {
            list.add(str);
        }


        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}