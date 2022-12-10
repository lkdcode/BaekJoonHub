import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// class Main으로 수정
public class Main {

    private static final BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));
    private static final String ABC = "ABC";
    private static final String DEF = "DEF";
    private static final String GHI = "GHI";
    private static final String JKL = "JKL";
    private static final String MNO = "MNO";
    private static final String PQRS = "PQRS";
    private static final String TUV = "TUV";
    private static final String WXYZ = "WXYZ";

    public static void main(String[] args) throws IOException {

        String input = BF.readLine();

        String[] split = input.split("");

        int sec = split.length;

        for (String str : split) {
            if (ABC.contains(str)) {
                sec += 2;
            }
            if (DEF.contains(str)) {
                sec += 3;
            }
            if (GHI.contains(str)) {
                sec += 4;
            }
            if (JKL.contains(str)) {
                sec += 5;
            }
            if (MNO.contains(str)) {
                sec += 6;
            }
            if (PQRS.contains(str)) {
                sec += 7;
            }
            if (TUV.contains(str)) {
                sec += 8;
            }
            if (WXYZ.contains(str)) {
                sec += 9;
            }

        }

        System.out.println(sec);

    }
}