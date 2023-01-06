import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final String L = "L";
    private static final String O = "O";
    private static final String V = "V";
    private static final String E = "E";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        String name = br.readLine();
        int size = Integer.parseInt(br.readLine());

        List<String> teams = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            teams.add(br.readLine());
        }
        Collections.sort(teams);

        int nameLLength = name.length() - name.replaceAll(L, "").length();
        int nameOLength = name.length() - name.replaceAll(O, "").length();
        int nameVLength = name.length() - name.replaceAll(V, "").length();
        int nameELength = name.length() - name.replaceAll(E, "").length();

        int max = 0;
        String result = teams.get(0);

        for (int i = 0; i < size; i++) {

            int teamLLength = teams.get(i).length() - teams.get(i).replaceAll(L, "").length();
            int teamOLength = teams.get(i).length() - teams.get(i).replaceAll(O, "").length();
            int teamVLength = teams.get(i).length() - teams.get(i).replaceAll(V, "").length();
            int teamELength = teams.get(i).length() - teams.get(i).replaceAll(E, "").length();

            int L = nameLLength + teamLLength;
            int O = nameOLength + teamOLength;
            int V = nameVLength + teamVLength;
            int E = nameELength + teamELength;

            int teamNameLength = winCalculator(L, O, V, E);
            if (max < teamNameLength) {
                max = teamNameLength;
                result = teams.get(i);
            }

        }

        System.out.println(result);


    }

    private static int winCalculator(int L, int O, int V, int E) {
        return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
    }
}
