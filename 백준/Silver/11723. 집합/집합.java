import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int command = Integer.parseInt(br.readLine());
        int bitmask = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < command; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int number;

            switch (input.nextToken()) {

                case "add":
                    number = Integer.parseInt(input.nextToken());
                    // add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
                    bitmask |= (1 << number);

                    // | 두 비트 중 1개만 1이면 1
                    break;
                case "remove":
                    // remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
                    number = Integer.parseInt(input.nextToken());

                    // & 두 비트가 모두 1이면 1

                    // 0010 -> 1인 경우
                    // 0010 -> 1이 된다
                    // 0000 -> 0이 된다 (반전으로 판단)

                    // 0000 -> 0인 경우
                    // 0010 -> 0이 된다
                    // 0000 -> 0이 된다 (반전으로 판단)
                    bitmask &= ~(1 << number);
                    break;
                case "check":
                    // check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
                    number = Integer.parseInt(input.nextToken());
                    // ^ 두 비트가 서로 다르면 1

                    // & 은 두 비트 모두 1 일 때만 1
                    //

                    if ((bitmask & (1 << number)) != 0) {
                        result.append(1).append("\n");
                        break;
                    }

                    result.append(0).append("\n");
                    break;

                case "toggle":
                    // toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
                    number = Integer.parseInt(input.nextToken());
                    // ~ 비트 반전


                    // 0010
                    // -> 0000

                    // 0000
                    // -> 0010

                    bitmask ^= (1 << number);
                    break;
                case "all":
                    // all: S를 {1, 2, ..., 20} 으로 바꾼다.
                    bitmask = (1 << 21) - 1;
                    break;

                case "empty":
                    // empty: S를 공집합으로 바꾼다.
                    bitmask = 0;
                    break;
            }


        }

        System.out.println(result);

    }


}
