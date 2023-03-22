import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 15
        int S = Integer.parseInt(st.nextToken()); // 28
        int M = Integer.parseInt(st.nextToken()); // 19

        Queue<Integer> queueE = new LinkedList<>();
        for (int i = 1; i <= 15; i++) {
            queueE.offer(i);
        }
        Queue<Integer> queueS = new LinkedList<>();
        for (int i = 1; i <= 28; i++) {
            queueS.offer(i);
        }
        Queue<Integer> queueM = new LinkedList<>();
        for (int i = 1; i <= 19; i++) {
            queueM.offer(i);
        }

        int result = 0;

        while (true) {
            result++;
            int numberE = queueE.poll();
            int numberS = queueS.poll();
            int numberM = queueM.poll();

            if (numberE == E && numberS == S && numberM == M) {
                break;
            }

            queueE.offer(numberE);
            queueS.offer(numberS);
            queueM.offer(numberM);
        }
        
        System.out.println(result);
    }
}
