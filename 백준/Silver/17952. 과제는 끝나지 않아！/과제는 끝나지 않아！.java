import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INPUT_EXAM = 1;
    private static Stack<Exam> stack = new Stack<>();
    private static int totalPoint = 0;

    public static class Exam {
        private int point;
        private int min;

        public Exam(int point, int min) {
            this.point = point;
            this.min = min;
        }

        public int getPoint() {
            return point;
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (Integer.parseInt(st.nextToken()) == INPUT_EXAM) {
                int point = Integer.parseInt(st.nextToken());
                int min = Integer.parseInt(st.nextToken());

                calculator(point, min);

            } else {

                if (stack.empty()) {
                    continue;
                }

                Exam exam = stack.pop();

                int point = exam.getPoint();
                int min = exam.getMin();

                calculator(point, min);
            }

        }

        System.out.println(totalPoint);
    }

    private static void calculator(int point, int min) {
        min--;

        if (min <= 0) {
            totalPoint += point;
        } else {
            stack.push(new Exam(point, min));
        }
    }

}
