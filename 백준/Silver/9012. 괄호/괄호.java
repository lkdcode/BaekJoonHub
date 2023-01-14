import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());

        Stack<Character> input = new Stack<>();

        for (int i = 0; i < size; i++) {
            boolean isYes = true;
            String brackets = bf.readLine();

            for (int j = 0; j < brackets.length(); j++) {
                char bracket = brackets.charAt(j);
                if (input.empty()) {
                    // 스택이 비어있을 경우
                    if (bracket == 40) {
                        // ( 를 받으면 추가
                        input.add(bracket);
                    } else {
                        // ) 를 받으면 NO 출력 후 종료
                        System.out.println("NO");
                        isYes = false;
                        break;
                    }
                } else {
                    // 스택이 안 비어있다면
                    if (bracket == 40) {
                        // ( 를 받으면 추가
                        input.add(bracket);
                    } else {
                        // ) 를 받으면
                        // peek 해서 40일 경우 삭제
                        // peek 해서 41일 경우 NO 출력 후 종료
                        if (input.peek() == 40) {
                            input.pop();
                        } else {
                            System.out.println("NO");
                            isYes = false;
                            break;
                        }
                    }
                }
            }

            if (!input.empty()) {
                System.out.println("NO");
            } else if (isYes) {
                System.out.println("YES");
            }
            input.clear();
        }
    }
}