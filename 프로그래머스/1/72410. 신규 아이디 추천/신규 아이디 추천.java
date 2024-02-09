class Solution {
    public String solution(String new_id) {
       
        StringBuilder answer = new StringBuilder();
        new_id = new_id.toLowerCase();

        for (char ch : new_id.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                answer.append(ch);
                continue;
            }

            if (ch >= '0' && ch <= '9') {
                answer.append(ch);
                continue;
            }

            if (ch == '-' || ch == '_' || ch == '.') {
                answer.append(ch);
                continue;
            }
        }

        new_id = answer.toString();
        answer = new StringBuilder();

        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.') {
                for (int j = i + 1; j < new_id.length(); j++) {
                    if (new_id.charAt(j) != '.') {
                        break;
                    }

                    i = j;
                }
            }
            answer.append(new_id.charAt(i));
        }

        if (answer.toString().startsWith(".")) {
            answer = new StringBuilder(answer.substring(1));
        }
        if (answer.toString().endsWith(".")) {
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }

        if (answer.length() == 0) {
            answer = new StringBuilder("a");
        }

        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));

            if (answer.toString().endsWith(".")) {
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
            }
        } else if (answer.length() <= 2) {
            while (answer.length() != 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        }

        return answer.toString();
    }
}