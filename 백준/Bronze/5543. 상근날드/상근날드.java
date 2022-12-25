import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int firstBurgerPrice = Integer.parseInt(bf.readLine());
        int secondBurgerPrice = Integer.parseInt(bf.readLine());
        int thirdBurgerPrice = Integer.parseInt(bf.readLine());

        int cokePrice = Integer.parseInt(bf.readLine());
        int spritePrice = Integer.parseInt(bf.readLine());

        int firstSet = firstBurgerPrice + cokePrice;
        int firstSet2 = firstBurgerPrice + spritePrice;

        int secondSet = secondBurgerPrice + cokePrice;
        int secondSet2 = secondBurgerPrice + spritePrice;

        int thirdSet = thirdBurgerPrice + cokePrice;
        int thirdSet2 = thirdBurgerPrice + spritePrice;


        int firstMin = Math.min(firstSet, firstSet2);
        int secondMin = Math.min(secondSet, secondSet2);
        int thirdMin = Math.min(thirdSet, thirdSet2);

        int result = Math.min(Math.min(firstMin, secondMin), thirdMin);

        System.out.println(result - 50);

    }
}