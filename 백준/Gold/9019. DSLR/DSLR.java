import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<DSLR> queue = new LinkedList<>();
            queue.add(new DSLR("", start));

            boolean[] visited = new boolean[10_001];

            w:
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    DSLR dslr = queue.poll();

                    int number = dslr.number;
                    String result = dslr.result;

                    if (number == target) {
                        System.out.println(result);
                        break w;
                    }

                    int d = D(number);
                    if (!visited[d]) {
                        visited[d] = true;
                        queue.add(new DSLR(result + "D", d));
                    }

                    int s = S(number);
                    if (!visited[s]) {
                        visited[s] = true;
                        queue.add(new DSLR(result + "S", s));
                    }

                    int l = L(number);
                    if (!visited[l]) {
                        visited[l] = true;
                        queue.add(new DSLR(result + "L", l));
                    }

                    int r = R(number);
                    if (!visited[r]) {
                        visited[r] = true;
                        queue.add(new DSLR(result + "R", r));
                    }

                }
            }

        }

    }

    private static int D(int number) {
        //D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
        return (number * 2) % 10_000;
    }

    private static int S(int number) {
        //S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
        return number == 0 ? 9999 : number - 1;
    }

    private static int L(int number) {
        //L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. R이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
        return ((number % 1000) * 10) + (number / 1000);
    }

    private static int R(int number) {
        //R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
        return ((number % 10) * 1000) + (number / 10);
    }

}

class DSLR {
    String result;
    int number;

    public DSLR(String result, int number) {
        this.result = result;
        this.number = number;
    }
}
