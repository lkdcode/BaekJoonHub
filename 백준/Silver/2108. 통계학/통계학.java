import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// class Main으로 수정
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> numbers = new ArrayList<>();
    private static int[] thirdList = new int[8001];
    private static int size = 0;
    private static int first = 0;
    private static int second = 0;
    private static int third = 0;
    private static int fourth = 0;

    public static void main(String[] args) throws IOException {

//        산술평균 : N개의 수들의 합을 N으로 나눈 값
//        중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//        최빈값 : N개의 수들 중 가장 많이 나타나는 값
//        범위 : N개의 수들 중 최댓값과 최솟값의 차이
        makeNumber();

        first();
        second();
        third();
        fourth();

        print();

    }

    private static void makeNumber() throws IOException {
        size = Integer.parseInt(bf.readLine());
        for (int i = 0; i < size; i++) {
            numbers.add(Integer.parseInt(bf.readLine()));
        }
    }

    private static void first() {
        double result = 0;

        for (int i = 0; i < numbers.size(); i++) {
            result += numbers.get(i);
        }
        result /= size;
        result = Math.round(result);
        first = (int) result;
    }

    private static void second() {
        Collections.sort(numbers);
        second = numbers.get((size / 2));
    }

    private static void third() {
        for (int i = 0; i < numbers.size(); i++) {
            thirdList[numbers.get(i) + 4000]++;
        }

        List<Integer> list = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < thirdList.length; i++) {
            if (thirdList[i] != 0) {
                max = Math.max(max, thirdList[i]);
            }
        }


        for (int i = 0; i < thirdList.length; i++) {
            if (thirdList[i] == max) {
                list.add(i);
            }
        }

        if (list.size() == 1) {
            third = (list.get(0) - 4000);
        }

        Collections.sort(list);

        if (list.size() != 1) {
            third = (list.get(1) - 4000);
        }

    }

    private static void fourth() {
        fourth = numbers.get(size - 1) - numbers.get(0);
    }

    private static void print() {
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
    }
}