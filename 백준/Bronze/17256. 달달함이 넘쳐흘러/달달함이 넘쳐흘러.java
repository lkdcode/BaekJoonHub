import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String firstInput = bf.readLine();
        String secondInput = bf.readLine();

        String[] firstInputSplit = firstInput.split(" ");
        String[] secondInputSplit = secondInput.split(" ");

        int ax = Integer.parseInt(firstInputSplit[0]);
        int ay = Integer.parseInt(firstInputSplit[1]);
        int az = Integer.parseInt(firstInputSplit[2]);

        int cx = Integer.parseInt(secondInputSplit[0]);
        int cy = Integer.parseInt(secondInputSplit[1]);
        int cz = Integer.parseInt(secondInputSplit[2]);

        List<Integer> result = new ArrayList<>();

        result.add(cx - az);
        result.add(cy / ay);
        result.add(cz - ax);

        System.out.println(result.get(0) + " " + result.get(1) + " " + result.get(2));

    }
}