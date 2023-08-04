import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        //1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
        //2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
        //3: 스택에 들어있는 정수의 개수를 출력한다.
        //4: 스택이 비어있으면 1, 아니면 0을 출력한다.
        //5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int menu = Integer.parseInt(st.nextToken());

            if (menu == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            }

            if (menu == 2) {
                if (stack.empty()) {
                    sb.append(-1)
                            .append(System.lineSeparator());
                } else {
                    sb.append(stack.pop())
                            .append(System.lineSeparator());
                }
                continue;
            }

            if (menu == 3) {
                sb.append(stack.size())
                        .append(System.lineSeparator());
                continue;
            }

            if (menu == 4) {
                if (stack.empty()) {
                    sb.append(1)
                            .append(System.lineSeparator());
                } else {
                    sb.append(0)
                            .append(System.lineSeparator());
                }
                continue;
            }

            if (menu == 5) {
                if (stack.empty()) {
                    sb.append(-1)
                            .append(System.lineSeparator());
                } else {
                    sb.append(stack.peek())
                            .append(System.lineSeparator());
                }
            }

        }
        System.out.println(sb);

    }

}
