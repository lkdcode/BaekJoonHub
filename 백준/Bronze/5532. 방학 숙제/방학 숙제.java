import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int vacation = Integer.parseInt(bf.readLine());
        int language = Integer.parseInt(bf.readLine());
        int math = Integer.parseInt(bf.readLine());
        int languageNeedDay = Integer.parseInt(bf.readLine());
        int mathNeedDay = Integer.parseInt(bf.readLine());

        int languageHomeWork = 0;
        int mathHomeWork = 0;

        while (language > 0) {
            language -= languageNeedDay;
            languageHomeWork++;
        }
        while (math > 0) {
            math -= mathNeedDay;
            mathHomeWork++;
        }

        System.out.println(vacation - Math.max(languageHomeWork, mathHomeWork));

    }
}