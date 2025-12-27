package middle;
import java.util.Scanner;

public class pro2{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int money = 5000;
		int plus, min;
		
	
		while (true) {
			System.out.print("돈을 얼마 입금하시겠습니까? : ");
			plus = s.nextInt();
			money += plus;
			
			System.out.print("돈을 얼마 출금하시겠습니까? : ");
			min = s.nextInt();
			money -= min;
			//money는 무조건 0보다 커야함
			//1) 입금
			//2) 출금
			//3) 잔액 확인
			//4) 종료
			
			if (money < min) {
				System.out.println("출금할 금액이 부족합니다!");
				break;
			}
		}
		System.out.printf("잔액은 %d원입니다.", money + min);
		s.close();
	}
}