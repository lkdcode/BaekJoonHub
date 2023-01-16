import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Stack<String> check = new Stack<>();


        while (true) {

            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }

            for (int i = 0; i < input.length(); i++) {
                if (check.empty() && input.charAt(i) == 41) {
                    check.add(String.valueOf(input.charAt(i)));
                    break;
                } else if (check.empty() && input.charAt(i) == 93) {
                    check.add(String.valueOf(input.charAt(i)));
                    break;
                }

                if (input.charAt(i) == 40 || input.charAt(i) == 91) {
                    check.add(String.valueOf(input.charAt(i)));
                } else if (input.charAt(i) == 41) {
                    if (check.peek().equals("(")) {
                        check.pop();
                    } else {
                        check.add(String.valueOf(input.charAt(i)));
                        break;
                    }
                } else if (input.charAt(i) == 93) {
                    if (check.peek().equals("[")) {
                        check.pop();
                    } else {
                        check.add(String.valueOf(input.charAt(i)));
                        break;
                    }
                }


            }

            if (check.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            check.clear();


        }

    }
}
