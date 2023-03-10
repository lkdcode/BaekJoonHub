import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();
        int roof = Integer.parseInt(bf.readLine());

        System.out.println(input.charAt(roof-1));
    }
}