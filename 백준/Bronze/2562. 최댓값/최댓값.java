import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = scan.nextInt();
		}

		int max = arr[0];

		for (int i = 0; i < 9; i++) {
			max = Math.max(arr[i], max);
		}
		int answer = 0;
		for (int i = 0; i < 9; i++) {
			answer++;
			if (arr[i] == max) {
				break;
			}
		}
		System.out.println(max);
		System.out.println(answer);

	}
}
