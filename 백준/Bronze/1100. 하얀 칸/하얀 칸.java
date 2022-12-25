import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int result = 0;

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 8; i++) {
            checkValidation(bf.readLine(), i);
        }

        System.out.println(result);

    }

//    0 2 4 6
//    .F.F...F      -> 1 -> 흰 검 흰 검 흰 검
//     1 3 5 7
//    F...F.F.      -> 2 -> 검 흰
//    ...F.F.F      -> 3 -> 흰 검 흰 검 흰 검
//    F.F...F.      -> 4 -> 검 흰
//    .F...F..      -> 5 -> 흰 검 흰 검 흰 검
//    F...F.F.      -> 6 -> 검 흰
//    .F.F.F.F      -> 7 -> 흰 검 흰 검 흰 검
//    ..FF..F.      -> 8 -> 검 흰

    private static void checkValidation(String input, int step) {
        if (step % 2 != 0) {
            for (int i = 0; i < input.length(); i += 2) {
                if (input.charAt(i) == 'F') {
                    result++;
                }
            }
        }

        if (step % 2 == 0) {
            for (int i = 1; i < input.length(); i += 2) {
                if (input.charAt(i) == 'F') {
                    result++;
                }
            }
        }

    }
}