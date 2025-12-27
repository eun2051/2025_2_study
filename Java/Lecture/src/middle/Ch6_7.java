package middle;
import java.util.Scanner;
import java.util.Random;

public class Ch6_7{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		int user, computer;
		
		while (true) {
			System.out.print("가위바위보! (가위 : 1, 바위 : 2, 보 : 0) : ");
			user= s.nextInt();
			if (user < 0 || user > 2) {
				System.out.println("잘못된 입력입니다. (0, 1 ,2) 중 하나를 선택하세요.");
				continue;
			}
			
			computer = r.nextInt(3);
			System.out.printf("컴퓨터의 선택은 %d입니다.\n", computer);
			
			if (user == computer) {
	            System.out.println("비겼습니다..");
	            continue;
	        } else if ((user == 1 && computer == 0) || (user == 2 && computer == 1) 
	        		|| (user == 0 && computer == 2)) {
	            System.out.println("이겼습니다.");
	            break;
	        } else {
	            System.out.println("졌습니다.");
	            continue;
	        }
		}
		System.out.println("축하합니다! 게임이 종료됩니다..");
		s.close();
	}
}