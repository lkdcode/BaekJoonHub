import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String form = br.readLine();
        Queue<Integer> subList = new LinkedList<>();

        int index = form.indexOf('-');

        String number = "";
        int result = 0;

        if (index != -1) {
            for (int i = 0; i < index; i++) {
                if (form.charAt(i) == '+') {
                    result += Integer.parseInt(number);
                    number = "";
                    continue;
                }
                number += form.charAt(i);
            }
            result += Integer.parseInt(number);

            String subNumber = "";
            for (int i = index + 1; i < form.length(); i++) {
                if (form.charAt(i) == '+' || form.charAt(i) == '-') {
                    subList.offer(Integer.parseInt(subNumber));
                    subNumber = "";
                    continue;
                }
                subNumber += form.charAt(i);
            }
            subList.offer(Integer.parseInt(subNumber));

            while (!subList.isEmpty()) {
                result -= subList.poll();
            }


        } else {
            String secondNumber = "";

            for (int i = 0; i < form.length(); i++) {
                if (form.charAt(i) == '+') {
                    result += Integer.parseInt(secondNumber);
                    secondNumber = "";
                    continue;
                }
                secondNumber += form.charAt(i);
            }

            result += Integer.parseInt(secondNumber);
        }


        System.out.println(result);

    }
}
