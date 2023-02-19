import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int findSize = Integer.parseInt(input[1]);

        String dna = br.readLine();
        input = br.readLine().split(" ");

        int[] ACGT = new int[4];
        int[] checkACGT = new int[4];

        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(input[i]);
            checkACGT[i] = 0;
        }
        // 입력

        int result = 0;

        for (int i = 0; i < findSize; i++) {
            char word = dna.charAt(i);

            if (word == 'A') {
                checkACGT[0]++;
            } else if (word == 'C') {
                checkACGT[1]++;
            } else if (word == 'G') {
                checkACGT[2]++;
            } else if (word == 'T') {
                checkACGT[3]++;
            }
        }

        boolean A = ACGT[0] <= checkACGT[0];
        boolean C = ACGT[1] <= checkACGT[1];
        boolean G = ACGT[2] <= checkACGT[2];
        boolean T = ACGT[3] <= checkACGT[3];

        if (A && C && G && T) {
            result++;
        }

        // 추가되는 문자, 삭제되는 문자로만 비교해서 체크하기


        int nexIndex = findSize;
        int oldIndex = 0;

        for (int i = findSize; i < size; i++) {

            int newWord = dna.charAt(nexIndex);
            int oldWold = dna.charAt(oldIndex);


            if (newWord == 'A') {
                checkACGT[0]++;
            } else if (newWord == 'C') {
                checkACGT[1]++;
            } else if (newWord == 'G') {
                checkACGT[2]++;
            } else if (newWord == 'T') {
                checkACGT[3]++;
            }

            if (oldWold == 'A') {
                checkACGT[0]--;
            } else if (oldWold == 'C') {
                checkACGT[1]--;
            } else if (oldWold == 'G') {
                checkACGT[2]--;
            } else if (oldWold == 'T') {
                checkACGT[3]--;
            }

            A = ACGT[0] <= checkACGT[0];
            C = ACGT[1] <= checkACGT[1];
            G = ACGT[2] <= checkACGT[2];
            T = ACGT[3] <= checkACGT[3];

            if (A && C && G && T) {
                result++;
            }

            nexIndex++;
            oldIndex++;
        }

        System.out.println(result);

    }
}
