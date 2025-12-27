package book_ch2;
import java.util.Scanner;

public class prob2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫 번째 수: ");
		String strNum1 = s.nextLine();
		
		System.out.print("두 번째 수: ");
		String strNum2 = s.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과: " + result);
		
		s.close();
	}
}
