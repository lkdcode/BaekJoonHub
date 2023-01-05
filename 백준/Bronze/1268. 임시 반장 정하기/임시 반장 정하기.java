import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());


        List<String> student = new ArrayList<>();
        int[] counts = new int[size];


        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            input = input.replace(" ", "");
            student.add(input);
        }


        for (int i = 0; i < size; i++) {
            List<String> anotherStudent = new ArrayList<>(student);
            counts[i] = calculator(student.get(i), anotherStudent);
        }


        int max = counts[0];
        for (int i = 1; i < counts.length; i++) {
            max = Math.max(max, counts[i]);
        }


        for (int i = 0; i < counts.length; i++) {
            if (max == counts[i]) {
                System.out.println(i + 1);
                return;
            }
        }

    }

    public static int calculator(String inputStudent, List<String> anotherStudent) {
        anotherStudent.remove(inputStudent);
        Set<Integer> friend = new HashSet<>();

        for (int i = 0; i < inputStudent.length(); i++) {
            char findDuplication = inputStudent.charAt(i);

            for (int j = 0; j < anotherStudent.size(); j++) {
                if (anotherStudent.get(j).charAt(i) == findDuplication) {
                    friend.add(j);
                }
            }
        }
        return friend.size();
    }
}
