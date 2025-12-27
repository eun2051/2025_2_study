package book_ch4;

public class Continuing {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
			//홀수는 실행x
		}
	}
}
