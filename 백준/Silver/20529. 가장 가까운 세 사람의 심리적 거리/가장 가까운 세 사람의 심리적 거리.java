import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int mbtiSize = Integer.parseInt(br.readLine());

            String[] mbti = br.readLine().split(" ");

            if (mbtiSize > 32) {
                System.out.println("0");
                continue;
            }

            int result = Integer.MAX_VALUE;

            for (int j = 0; j < mbtiSize; j++) {
                for (int k = j + 1; k < mbtiSize; k++) {
                    for (int l = k + 1; l < mbtiSize; l++) {
                        result = Math.min(result, cal(mbti[j], mbti[k], mbti[l]));
                    }
                }
            }

            System.out.println(result);
        }

    }

    private static int cal(String mtbi1, String mtbi2, String mtbi3) {
        return calDistance(mtbi1, mtbi2) + calDistance(mtbi1, mtbi3) + calDistance(mtbi2, mtbi3);
    }

    private static int calDistance(String mbti1, String mbti2) {
        int distance = 0;

        if (mbti1.charAt(0) != mbti2.charAt(0)) distance++;
        if (mbti1.charAt(1) != mbti2.charAt(1)) distance++;
        if (mbti1.charAt(2) != mbti2.charAt(2)) distance++;
        if (mbti1.charAt(3) != mbti2.charAt(3)) distance++;

        return distance;
    }


}
