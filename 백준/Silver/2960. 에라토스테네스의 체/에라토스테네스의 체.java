import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int step = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[size + 1];
        prime = makePrime(size, step);


    }

    static boolean[] makePrime(int size, int resultCount) {
        boolean[] prime = new boolean[size + 1];
        prime[0] = prime[1] = true;
        int count = 0;

        for (int i = 2; i <= size; i++) {
            for (int j = i; j <= size; j += i) {
                if (!prime[j]) {
                    prime[j] = true;
                    count++;
                }
                if (count == resultCount) {
                    System.out.println(j);
                    return null;
                }
            }
        }

        return prime;
    }
}
