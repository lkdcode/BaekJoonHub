import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자들의 개수
        int n = Integer.parseInt(br.readLine());
        // 숫자들을 담을 배열
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        // 결과를 담은 변수
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            // 구간 합
            long sum = 0;
            int j = i;
            while (j < arr.length) {
                sum += arr[j];
                // 구간 합이 k보다 클 경우
                if (sum > k) {
                    count += arr.length - j;
                    break;
                } else {
                    j++;
                }
            }
        }
        System.out.println(count);
    }
}