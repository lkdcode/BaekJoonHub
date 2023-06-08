import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] student;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken()) + 3; // 학생 수
        int sleepStudentSize = Integer.parseInt(st.nextToken()); // 졸고 있는 학생 수
        int sendCodeSize = Integer.parseInt(st.nextToken()); // 출석 코드를 보내는 횟수
        int rangeSize = Integer.parseInt(st.nextToken()); // 주어질 범위의 횟수

        student = new int[size];
        visited = new boolean[size];

        // 모든 학생은 1 로 마킹해준다.
        Arrays.fill(student, 1);
        student[0] = 0;
        student[1] = 0;
        student[2] = 0;

        // 졸고 있는 학생의 번호는 방문처리해준다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sleepStudentSize; i++) {
            visited[Integer.parseInt(st.nextToken())] = true;
        }

        // 출석 문자를 보낸 학생의 배수를 0으로 바꿔준다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sendCodeSize; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (visited[number]) continue;

            for (int j = number; j < size; j += number) {
                if (visited[j]) continue;
                student[j] = 0;
            }

        }

        // 학생 누적합 구하기
        int[] sum = new int[size];
        for (int i = 3; i < size; i++) {
            sum[i] = sum[i - 1] + student[i];
        }
        List<String> result = new ArrayList<>();

        // 범위의 결과값 출력하기
        for (int i = 0; i < rangeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            result.add(sum[endIndex] - sum[startIndex - 1] + "");
        }

        result.forEach(System.out::println);


//        System.out.println();
//        System.out.println();
//        System.out.println();
//        int index = 0;
//        for (int i : student) {
//            System.out.printf("%4d ", index++);
//        }
//
//        System.out.println();
//        for (int i : student) {
//            System.out.printf("%4d ", i);
//        }
//
//        System.out.println();
//
//        for (int i : sum) {
//            System.out.printf("%4d ", i);
//        }
    }

}


//5 1 1 1
//3
//3
//3 7