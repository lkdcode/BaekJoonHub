import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String ADD_WORD = "OI";

    public static void main(String[] args) throws IOException {
        int findSize = Integer.parseInt(br.readLine());
        int wordSize = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int result = 0;

        StringBuilder findWord = new StringBuilder();
        findWord.append("IOI");

        for (int i = 1; i < findSize; i++) {
            findWord.append(ADD_WORD);
        }

        // 사이즈만큼 잘라서 추가해서 비교하기
        // word를 0부터 시작해서
        // findWord 사이즈만큼 substring으로 만들고
        // Queue에 담아서 맞는지 체크하기

        // startIndex 이상, endIndex 미만
        int endIndex = findWord.length();


        Queue<String> checkList = new LinkedList<>();
        for (int i = 0; i < word.length() - findWord.length() + 1; i++) {
            checkList.offer(word.substring(i, endIndex++));
        }

        while (!checkList.isEmpty()) {
            if (checkList.poll().equals(findWord.toString())) result++;
        }

        System.out.println(result);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//      맞왜틀........
//        int calFindSize = (findSize * 2) + 1;
//        for (int i = 0; i < wordSize - calFindSize; i++) {
//            int OIndex = i + 1;
//            int IIndex = i + 2;
//
//            if (word.charAt(i) == 'I') {
//                int check = 0;
//
//                for (int j = 0; j < findSize; j++) {
//                    if (word.charAt(OIndex) == 'O' && word.charAt(IIndex) == 'I') {
//                        check++;
//                    }
//                    OIndex += 2;
//                    IIndex += 2;
//                }
//
//                if (check == findSize) result++;
//            }
//        }
//
//        System.out.println(result);

//        1
//        13
//        OOIOIOIOIIOII

/**
 *  왜 틀리는지 모르겠다..

 StringBuilder findWord = new StringBuilder();
 findWord.append("IOI");

 for (int i = 1; i < findSize; i++) {
 findWord.append("O")
 .append("I");
 }

 for (int i = 0; i < wordSize - findWord.length(); i++) {
 if (word.charAt(i) == 'O') continue;

 StringBuilder check = new StringBuilder();

 for (int j = i; j < findWord.length() + i; j++) {
 check.append(word.charAt(j));
 }

 if (check.toString().equals(findWord.toString())) result++;
 }

 맞 왜 틀*/


    }
}
