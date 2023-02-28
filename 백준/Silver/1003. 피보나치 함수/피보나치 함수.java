import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] fibonacci = new int[41];
    private static int resultZero = 0;
    private static int resultOne = 0;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        makeFibonacci();
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                System.out.println("1 0");
                continue;
            } else if (number == 1) {
                System.out.println("0 1");
                continue;
            }
            System.out.println(fibonacci[number - 1] + " " + fibonacci[number]);
        }

    }

    //     0 1 1 2 3 5 8 13 21
    //0 -> 1 0 1 1 2 3 5
    //1 -> 0 1 1 2 3 5 8 13 21 34


//    static int fibonacci(int n) {
//        if (n == 0) {
//            resultZero++;
//            return 0;
//        } else if (n == 1) {
//            resultOne++;
//            return 1;
//        } else {
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//    }


    static void makeFibonacci() {
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }
    }
}

