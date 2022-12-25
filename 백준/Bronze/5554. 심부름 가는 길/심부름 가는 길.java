import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int schoolAtHome = Integer.parseInt(bf.readLine());
        int pcAtSchool = Integer.parseInt(bf.readLine());
        int academyAtPc = Integer.parseInt(bf.readLine());
        int homeAtAcademy = Integer.parseInt(bf.readLine());

        int total = schoolAtHome + pcAtSchool + academyAtPc + homeAtAcademy;
        int minute = total / 60;
        int sec = total % 60;

        System.out.println(minute);
        System.out.println(sec);

    }
}