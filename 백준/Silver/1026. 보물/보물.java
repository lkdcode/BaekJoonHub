import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        List<Integer> ANumbers = new ArrayList<>();
        List<Integer> BNumbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            ANumbers.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            BNumbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(ANumbers, Collections.reverseOrder());
        Collections.sort(BNumbers);

        int result= 0;
        for (int i = 0; i <size ; i++) {
            result += (ANumbers.get(i) * BNumbers.get(i));
        }
        System.out.println(result);

    }
}
