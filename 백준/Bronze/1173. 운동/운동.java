import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int N = SCAN.nextInt(); // 운동 시간 N

        int m = SCAN.nextInt(); // m-R 이 m보다 작으면 맥박은 m , 초기 맥박
        int M = SCAN.nextInt(); // m+T 가 M보다 작거나 같을 때만 운동 가능

        int T = SCAN.nextInt(); // 1분 후 맥박이 T 만큼 증가
        int R = SCAN.nextInt(); // 1분 휴식 후 R 만큼 감소

        int heart = m;
        int training = 0;
        int timeCount = 0;

        if (m + T > M) {
            System.out.println("-1");
            return;
        }

        while (true) {

            if (N == training) {
                break;
            }

            if (heart + T <= M) {
                heart += T;
                training++;
                timeCount++;
            }

            if (N == training) {
                break;
            }

            if (heart + T > M) {
                heart -= R;
                timeCount++;
            }

            if (N == training) {
                break;
            }

            if (heart <= m) {
                heart = m;
            }

        }

        System.out.println(timeCount);

    }
}