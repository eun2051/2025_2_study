package middle;
import java.util.Scanner;
//import java.util.Random;

public class pro4{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//Random r = new Random();
		
		int money, num;
		int left;
		System.out.print("투입가능금액 : 100, 500, 1000, 5000");
		System.out.println("투입하실 금액을 입력하시오.");
		money = s.nextInt();
		
		if (money < 0) {
			System.out.println("잘못된 금액입니다.");
		}
		
		System.out.println("상품 : 물(700) , 콜라(1500) , 솔의 눈(2200)");
		System.out.print("상품을 선택해주세요 : ");
		num = s.nextInt();
		
		left = money;
		if (money > num) {
			money -= num;
			if (num > 5000) {
				if (num > 1000) {
					if (num > 500) {
						if (num > 100) {
							left /= money;
							System.out.printf("거스름돈은 %d원입니다.",left);
						}
					}
				}
			}
		}
		s.close();
	}
}