package book_ch2;
import java.util.Scanner;

public class Stringinput {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input;
		
		while (true) {
			System.out.print("문자열을 입력해주세요 (종료 q) : ");
			input = s.nextLine();
			System.out.println("입력된 문자열 : \"" + input + "\"");
			if (input.equals("q")) {
				break;
			}
		}
		System.out.println("종료");
		s.close();
	}
}
