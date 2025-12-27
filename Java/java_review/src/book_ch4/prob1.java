package book_ch4;
import java.util.Scanner;

public class prob1 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner s = new Scanner(System.in);
		
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.print("선택 > ");
			int choice = s.nextInt();
			int mon, min;
			
			switch(choice) {
				case 1:
					System.out.print("예금액> ");
					mon = s.nextInt();
					balance += mon;
					break;
				case 2: 
					System.out.print("출금액> ");
					min = s.nextInt();
					balance -= min;
					break;
				case 3: 
					System.out.println("잔고> " + balance);
					break;
				case 4:
					run = false;
					break;
				default:
					System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.println("프로그램 종료");
		s.close();
	}
}
